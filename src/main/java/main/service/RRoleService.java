package main.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RRoleService {


    public Set<String> getRolesByUserName(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("user");
        return roles;
    }

}
