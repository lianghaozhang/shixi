package com.aniu.spring6.test;

import com.aniu.spring6.bean.Eason;
import com.aniu.spring6.bean.Person;
import com.aniu.spring6.service.StudentService;
import com.aniu.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {


    @Test // 测试set方法注入
    public void testSetDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = context.getBean(UserService.class);
        userService.saveUserInfo();
    }

    @Test // 测试构造方法注入
    public void testConstructDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        StudentService studentService = context.getBean(StudentService.class);
        studentService.print();
    }

    @Test // 测试简单类型的set方法注入
    public void testSimpleTypeDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void testNs_p(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-p.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void testSpringProperties(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties.xml");
        Eason eason = context.getBean(Eason.class);
        System.out.println(eason);
    }
}
