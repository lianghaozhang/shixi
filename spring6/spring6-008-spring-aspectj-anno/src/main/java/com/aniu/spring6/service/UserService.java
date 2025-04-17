package com.aniu.spring6.service;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void getUserList(){
        System.out.println("获取用户列表");
    }
}
