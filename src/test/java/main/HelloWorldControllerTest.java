package main;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
public class HelloWorldControllerTest {

    @Test
    public void getUser() {
        HomeProperties homeProperties = new HomeProperties();
        Assert.assertEquals(homeProperties.getCity(),"dd" );
    }
}