package com.aniu.spring6.service;

import com.aniu.spring6.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUserInfo() {
        userDao.user();
    }
}
