package main;

import main.dao.UserDao;
import main.domain.DbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @Autowired
    private UserDao userDao;

    @GetMapping("/insert/{username}")
    public String insertUser(@PathVariable(value = "username") String username) {
        if (username == null || "".equals(username)) {
            return "username is null";
        }
        userDao.insertUser(new DbUser(null, username, "pass111", 1));
        StringBuilder sb = new StringBuilder("list:\n");
        List<DbUser> allUsers = userDao.findAllUsers();
        for (DbUser item : allUsers) {
            sb.append("\n");
            sb.append("id:");
            sb.append(item.getIduser());
            sb.append("\n");
            sb.append("username:");
            sb.append(item.getUsername());

        }

        return sb.toString();
    }


}
