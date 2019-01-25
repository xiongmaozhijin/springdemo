package main.configura;

import main.service.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    @Bean
    public Realm realm() {
        CustomRealm realm = new CustomRealm();
        return realm;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        bean.setLoginUrl("/shiro/login");
        bean.setSuccessUrl("/shiro/home");
//        bean.setUnauthorizedUrl("/shiro/for401");

        Map<String, String> filterChainDefinition = new HashMap<>();
        filterChainDefinition.put("/shiro/user/**", "authc, roles[user]");
        filterChainDefinition.put("/shiro/admin/**", "authc, roles[admin]");
        filterChainDefinition.put("/shiro/login/**", "anon");
        filterChainDefinition.put("/shiro/logout", "logout");
        filterChainDefinition.put("/shiro/**", "anon");
        bean.setFilterChainDefinitionMap(filterChainDefinition);

        return bean;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

//        chainDefinition.addPathDefinition("/shiro/user/**", "authc, roles[user]");
//        chainDefinition.addPathDefinition("/shiro/admin/**", "authc, roles[admin]");
//        chainDefinition.addPathDefinition("/shiro/login/**", "anon");
//        chainDefinition.addPathDefinition("/shiro/logout", "logout");
//        chainDefinition.addPathDefinition("/shiro/**", "anon");


        return chainDefinition;
    }

//
//    @Bean
//    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        /**
//         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
//         * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，导致返回404。
//         * 加入这项配置能解决这个bug
//         */
//        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
//        return defaultAdvisorAutoProxyCreator;
//    }
//
//


}
