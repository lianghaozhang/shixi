package com.aniu.metadba.service;

import com.aniu.metadba.entity.User;
import com.aniu.metadba.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User checkLogin(String username, String password) {
        return userMapper.checkLogin(username, password);
    }

    public Integer getUserIdByUsername(String username) {
        return userMapper.getUserIdByUsername(username);
    }
}
