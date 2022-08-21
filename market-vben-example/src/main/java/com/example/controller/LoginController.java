package com.example.controller;

import com.example.common.utils.ResResult;
import com.example.domain.LoginUser;
import com.example.domain.SysUser;
import com.example.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
@Api(value = "LoginController", tags = "登录模块")
@RequestMapping("user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    @ApiOperation(value = "登录接口")
    public ResResult login(@RequestBody SysUser user) {
        return loginService.login(user);
    }

    @PostMapping("logout")
    @ApiOperation(value = "退出接口")
    public ResResult login() {
        // 获取当前登录用户的信息
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        // 转为 UserDetails 对象
        LoginUser user = (LoginUser) authentication.getPrincipal();
        // 获取 userId
        Long userId = user.getUser().getId();
        return ResResult.success();
    }

}
