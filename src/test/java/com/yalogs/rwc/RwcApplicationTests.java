package com.yalogs.rwc;

import com.yalogs.rwc.user.entity.User;
import com.yalogs.rwc.user.service.impl.UserServiceImpl;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.Date;

@SpringBootTest
class RwcApplicationTests {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.yml");

    @Test
    public void test1() {

    }

}
