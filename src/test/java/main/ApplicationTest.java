package main;

import main.dao.UserDao;
import main.domain.DbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertUser() {
        DbUser dbUser = new DbUser(null, "libai", "123456", 4);
        userDao.insertUser(dbUser);
    }

    @Test
    public void findAllUsers() {
        List<DbUser> allUsers = userDao.findAllUsers();
        for (DbUser item : allUsers) {
            System.out.println(item);
        }
    }

}