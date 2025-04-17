package com.aniu.metadba.controller;

import com.aniu.metadba.entity.User;
import com.aniu.metadba.service.UserService;
import com.aniu.metadba.utils.ResponseJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/api/login")
    public ResponseJson checkLogin(@RequestBody User user) {
        User resUser = userService.checkLogin(user.getUsername(), user.getPassword());
        if(Objects.isNull(resUser)) {
            return new ResponseJson(999, "用户名或密码有误，请重新输入", null);
        }

        return new ResponseJson(200, "登录成功", resUser);
    }
}
