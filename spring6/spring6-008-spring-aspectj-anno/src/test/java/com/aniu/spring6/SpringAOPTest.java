package com.aniu.spring6;

import com.aniu.spring6.service.UserService;
import config.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {

    @Test
    public void testXmlConfig(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = context.getBean(UserService.class);
        userService.getUserList();
    }

    @Test
    public void testSpringConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserService userService = context.getBean(UserService.class);
        userService.getUserList();
    }
}
