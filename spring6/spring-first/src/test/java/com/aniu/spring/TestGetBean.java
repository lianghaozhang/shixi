package com.aniu.spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {

    @Test
    public void getBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Logger logger = LoggerFactory.getLogger(TestGetBean.class);
        logger.info("1");
        logger.debug("1");
        logger.error("1");
        System.out.println(context.getBean("user"));
    }
}
