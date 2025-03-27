package com.aniu.spring6.bean.lifecycle;

import com.aniu.com.aniu.spring6.bean.lifecycle.Student;
import com.aniu.com.aniu.spring6.bean.lifecycle.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {

    @Test
    public void test5Lifecycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println("第四步：使用bean【" + user + "】");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testRegisterBean() {
        Student s1 = new Student();
        System.out.println(s1);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton("student", s1);
        Student s2 = beanFactory.getBean(Student.class);
        System.out.println(s2);
    }
}
