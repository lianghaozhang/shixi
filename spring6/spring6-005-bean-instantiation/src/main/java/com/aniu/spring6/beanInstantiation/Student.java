package com.aniu.spring6.beanInstantiation;

import java.util.Date;

public class Student {

    private Date birthday;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

//    public Student() {
//        System.out.println("Student的无参构造执行");
//    }


    @Override
    public String toString() {
        return "Student{" +
                "birthday=" + birthday +
                '}';
    }
}
