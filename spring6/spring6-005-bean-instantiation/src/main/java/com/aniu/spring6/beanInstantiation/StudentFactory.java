package com.aniu.spring6.beanInstantiation;

import org.springframework.beans.factory.FactoryBean;

public class StudentFactory implements FactoryBean<Student> {

    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
