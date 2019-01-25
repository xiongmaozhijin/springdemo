package main.service;

import main.domain.SUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private RUserService rUserService;
    @Autowired
    private RRoleService rRoleService;
    @Autowired
    private RPermService rPermService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null");
        }

        SUser sUser = (SUser) getAvailablePrincipal(principals);
        Set<String> rolesByUserName = rRoleService.getRolesByUserName(sUser.getName());
        Set<String> permisionByUsername = rPermService.getPermisionByUsername(sUser.getName());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(rolesByUserName);
        info.setStringPermissions(permisionByUsername);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        if (username == null) {
            throw new AccountException("Null username are not allowed by this realm");
        }
        SUser userByName = rUserService.findUserByName(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userByName, userByName.getPassword(), getName());

        return info;
    }

}
