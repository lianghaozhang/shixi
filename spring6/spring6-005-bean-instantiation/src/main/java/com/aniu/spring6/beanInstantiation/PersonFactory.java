package com.aniu.spring6.beanInstantiation;

public class PersonFactory {

    public static Person getPerson() {
        return new Person();
    }
}
