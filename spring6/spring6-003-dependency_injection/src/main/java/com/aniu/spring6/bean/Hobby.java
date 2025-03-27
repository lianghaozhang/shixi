package com.aniu.spring6.bean;

public class Hobby {
    private String hobbyName;

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                '}';
    }
}
