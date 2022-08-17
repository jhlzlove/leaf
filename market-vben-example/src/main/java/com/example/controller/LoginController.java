package com.market.example.controller;

import com.market.example.domain.LoginUser;
import com.market.example.domain.SysUser;
import com.market.example.service.LoginService;
import com.market.example.utils.ResResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
@RequestMapping("user")
public class LoginController {

    private final LoginService loginService;
    private final RedisTemplate redisTemplate;

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
        // 删除Redis信息
        redisTemplate.delete(userId);
        return ResResult.success();
    }

    @Autowired
    public LoginController(LoginService loginService, RedisTemplate redisTemplate) {
        this.loginService = loginService;
        this.redisTemplate = redisTemplate;
    }
}
