package com.aniu.springsecurity.controller;

import com.aniu.springsecurity.Mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("test")
    public String test(){
        return "hello!";
    }
}
