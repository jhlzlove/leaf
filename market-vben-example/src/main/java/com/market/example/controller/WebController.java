package com.market.example.controller;

import com.market.example.domain.SysUser;
import com.market.example.service.impl.UserDetailServiceImpl;
import com.market.example.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clf
 * @time 2022/8/10 11:45
 * @desc: WebController
 */
@RestController
public class WebController {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @PostMapping("register")
    public Response register(SysUser user) {
        userDetailService.register(user);
        return Response.success("注册成功");
    }
}
