package com.aniu.metadba.controller;

import com.aniu.metadba.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/api/getUserId")
    public Integer getUserIdByUsername(@Param("username") String username) {
        return userService.getUserIdByUsername(username);
    }
}
