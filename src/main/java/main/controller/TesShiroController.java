package main.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/shiro")
public class TesShiroController {

    private static final Logger log = LoggerFactory.getLogger(TesShiroController.class);

    @GetMapping("/home")
    public String home() {
        log.error("home().......");
        return "shiro, home";
    }

    @GetMapping("/res/{title}")
    public String getResource(@PathVariable(value = "title") String title) {
        return "shiro, " + title;
    }

    @GetMapping("/user/{username}")
    public String getUserInfo(HttpServletRequest request, @PathVariable(value = "username") String username) {
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.err.println("exception=" + exception);

        return "user, " + username;
    }

    @GetMapping("/for401")
    public String for401() {
        return "没有权限";
    }

    @GetMapping("/login")
    public String loginView() {
        return "登录页";
    }

    @GetMapping("/login/{username}")
    public String login(@PathVariable(value = "username") String username) {
        SecurityUtils.getSubject().login(new UsernamePasswordToken(username, "123456"));
        return "login, " + username;
    }

    @GetMapping("/admin/{username}")
    public String admin(@PathVariable(value = "username") String username) {
        return "admin, " + username;
    }

    @GetMapping("/testException")
    public String testException() {
        log.error("testException");
        if (System.currentTimeMillis() % 7 != 1) {
            throw new IllegalArgumentException("没有参数哦哦哦");
        }

        return "testException";
    }

}
