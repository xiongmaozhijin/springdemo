package main.service;

import main.domain.SUser;
import org.springframework.stereotype.Service;

@Service
public class RUserService {

    public SUser findUserByName(String username) {
        SUser sUser= new SUser(1L, "libai", "123456");
        return sUser;
    }

}
