package com.aniu.spring6.bean;

import java.util.Arrays;

public class Person {
    private String name;
    private int age;
//    private String[] hobby;
    private Hobby[] hobby;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setHobby(Hobby[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
