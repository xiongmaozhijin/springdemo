package main.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RPermService {

    public Set<String> getPermisionByUsername(String username) {
        Set<String> perms = new HashSet<>();
        perms.add("view");
        perms.add("edit");
        return perms;
    }

}
