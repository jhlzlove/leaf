package com.market.example.controller;

import com.market.example.domain.SysUser;
import com.market.example.service.LoginService;
import com.market.example.utils.ResResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clf
 * @time 2022/8/13 17:56
 * @desc: LoginController
 */
@RestController
@RequestMapping("user")
public class LoginController {

    private final LoginService loginService;


    @PostMapping("login")
    @ApiOperation(value = "登录接口")
    public ResResult login(@RequestBody SysUser user) {
        return loginService.login(user);
    }

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
}
