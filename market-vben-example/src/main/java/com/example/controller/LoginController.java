package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysUser;
import com.example.domain.resp.LoginUserInfo;
import com.example.service.LoginService;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;

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
    public LoginUserInfo login(@RequestBody SysUser user) {
        return loginService.login(user);
    }

    @GetMapping("getUserInfo")
    @ApiOperation(value = "getUserInfo", notes = "用户信息")
    public SysUser getUserInfo() {
        SysUser userInfo = loginService.getUserInfo();
        return userInfo;
    }

    @GetMapping("tokenExpired")
    @ApiOperation(value = "tokenExpired", notes = "token 过期时间")
    public SysUser tokenExpired() {
        return null;
    }

    /**
     * 生成验证码
     *
     * @param session
     * @return base64
     */
    @GetMapping("vc")
    @ApiOperation(value = "verifycode", notes = "验证码生成")
    public String getVerifyCode(HttpSession session) {
        String text = producer.createText();
        session.setAttribute("kaptcha", text);
        // 生成图片
        BufferedImage bi = producer.createImage(text);
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpg", fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 返回 base64 字符串
        return Base64.getEncoder().encodeToString(fos.toByteArray());
    }

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final Producer producer;
    private final LoginService loginService;

    public LoginController(LoginService loginService, Producer producer) {
        this.loginService = loginService;
        this.producer = producer;
    }
}
