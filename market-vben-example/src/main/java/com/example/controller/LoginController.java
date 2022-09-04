package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysUser;
import com.example.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author jhlz
 * @time 2022/9/1 12:56
 * @desc: LoginController
 */
@ApiRestController
@RequestMapping("system")
@Api(value = "LoginController", tags = "登录管理")
public class LoginController {

    @PostMapping("login")
    @ApiOperation(value = "login", notes = "用户登录")
    public Map<String, Object> login(@RequestBody SysUser user) {
        return loginService.login(user);
    }

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
}
