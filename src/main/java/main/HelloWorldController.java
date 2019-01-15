package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private HomeProperty homeProperty;

    @Value("${env.tip}")
    private String tip;

    @GetMapping("/testConfig")
    public String testConfig() {
        return String.format("%s, %s", homeProperty.getTip(), tip);
    }
}
