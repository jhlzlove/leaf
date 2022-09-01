package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysUser;
import com.example.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @time 2022/9/1 8:37
 * @desc: SysUserController
 */
@ApiRestController
@RequestMapping("system")
@Api(value = "SysUserController", tags = "用户管理")
public class SysUserController {

    @PostMapping("register")
    @ApiOperation(value = "register", notes = "用户注册")
    public SysUser register(@RequestBody SysUser user) {
        return userService.register(user);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "delete", notes = "删除")
    public SysUser delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PutMapping("enable")
    @ApiOperation(value = "enable", notes = "账户启用/禁用")
    public SysUser enabled(Long id) {
        return userService.enabled(id);
    }

    @PutMapping("update")
    @ApiOperation(value = "update", notes = "账户更新")
    public SysUser update(@RequestBody SysUser user) {
        return userService.update(user);
    }

    private final SysUserService userService;

    public SysUserController(SysUserService userService) {
        this.userService = userService;
    }
}
