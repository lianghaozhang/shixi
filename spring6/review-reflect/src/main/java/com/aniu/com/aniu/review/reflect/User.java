package com.aniu.com.aniu.review.reflect;

public class User {
    private String name = "***";
    private int age = -1;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void look_noArg(){
        System.out.println("name=" + name + " age=" + age);
    }

    public void look_oneArg(String name){
        System.out.println("name=" + name + " age=" + age);
    }

    public void look_twoArg(String name, int age){
        System.out.println("name=" + name + " age=" + age);
    }
}
