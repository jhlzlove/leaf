package com.market.example.controller;

import com.market.example.domain.SysUser;
import com.market.example.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author clf
 * @time 2022/8/13 11:32
 * @desc: LoginController
 */
public class LoginController {

    @GetMapping("login")
    @ApiOperation(value = "登录接口")
    public Response login(@RequestBody SysUser user) {
        return Response.success();
    }

}
