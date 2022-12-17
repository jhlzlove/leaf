package com.example.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jhlz
 * @since: 2022/12/14 19:43:14
 */
@Api(value = "登录模块", tags = "登录模块")
@RestController
public class LoginController {

    @PostMapping("login")
    @ApiOperation(value = "登录", notes = "登录系统")
    public void login(String userName, String password) {

    }

    @PostMapping("logout")
    @ApiOperation(value = "登出", notes = "登出系统")
    public void logout(String userName, String password) {

    }
}
