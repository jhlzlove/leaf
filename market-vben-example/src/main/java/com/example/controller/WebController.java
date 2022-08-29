package com.example.controller;

import com.example.domain.SysUser;
import com.example.service.impl.UserDetailServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @time 2022/8/10 11:45
 * @desc: WebController
 */
@RestController
@RequestMapping("/openapi")
@Api(value = "Web", tags = "OpenApi测试")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    private final UserDetailServiceImpl userDetailService;

    // @Autowired
    public WebController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("register")
    @ApiOperation(value = "register", tags = "添加新用户")
    public SysUser register(SysUser user) {
        userDetailService.register(user);
        return user;
    }

    @PostMapping("login")
    @ApiOperation(value = "login", tags = "用户登录")
    public UserDetails login(@RequestBody SysUser user) {
        UserDetails userDetails = userDetailService.loadUserByUsername(user.getUserName());
        return userDetails;
    }

    @PostMapping("logout")
    @ApiOperation(value = "logout", tags = "退出")
    public String logout(@RequestBody SysUser user) {

        return null;
    }

    @PostMapping("getUserInfo")
    @ApiOperation(value = "getUserInfo", tags = "获取用户信息")
    public SysUser getUserInfo(SysUser user) {
        SysUser userInfo = userDetailService.getUserInfo(user);
        return userInfo;
    }
}
