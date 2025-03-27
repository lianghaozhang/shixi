package com.aniu.spring6.service;

import com.aniu.spring6.dao.StudentDao;
import com.aniu.spring6.dao.UserDao;

public class StudentService {
    private StudentDao studentDao;
    private UserDao userDao;

    public StudentService(StudentDao studentDao, UserDao userDao) {
        this.studentDao = studentDao;
        this.userDao = userDao;
    }

    public void print(){
        studentDao.student();
        userDao.user();
    }
}
