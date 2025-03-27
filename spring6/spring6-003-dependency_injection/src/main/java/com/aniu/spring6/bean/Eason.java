package com.aniu.spring6.bean;

public class Eason {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Eason{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
