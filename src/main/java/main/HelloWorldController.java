package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "hello world!";
    }

    @RequestMapping("/users/1")
    public User getUser() {
        return new User(1L, "李白libai");
    }
}
