package com.market.example.controller;

import com.market.example.domain.SysUser;
import com.market.example.service.impl.UserDetailServiceImpl;
import com.market.example.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author clf
 * @time 2022/8/10 11:45
 * @desc: WebController
 */
@RestController
@Api(value = "Web")
@RequestMapping("/nonauth")
public class WebController {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @PostMapping("register")
    @ApiOperation(value = "注册接口", notes = "添加新用户")
    public Response register(SysUser user) {
        userDetailService.register(user);
        return Response.success("注册成功");
    }

    @GetMapping("get/{name}")
    @ApiOperation(value = "查询用户", notes = "查询用户信息")
    public Response getByUserName(@PathVariable("name") String username) {
        return Response.success(userDetailService.loadUserByUsername(username));
    }

    /**
     * 修改用户信息
     *
     * @param username
     * @return
     */
    @PutMapping("update/{name}")
    @ApiOperation(value = "查询用户", notes = "更新用户信息")
    public Response updateByUserName(@PathVariable("name") String username) {
        return Response.success(userDetailService.loadUserByUsername(username));
    }

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    @DeleteMapping("delete/{name}")
    @ApiOperation(value = "查询用户", notes = "删除用户信息")
    public Response deleteByUserName(@PathVariable("name") String username) {
        return Response.success(userDetailService.loadUserByUsername(username));
    }
}
