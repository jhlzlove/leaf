package com.example.controller;

import com.example.domain.SysUser;
import com.example.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @time 2022/9/1 8:37
 * @desc: SysUserController
 */
@RestController
@RequestMapping("system")
@Api(value = "SysUserController", tags = "帐户管理")
public class SysUserController {

    @GetMapping("login")
    @ApiOperation(value = "login", tags = "登录")
    public UserDetails login(@RequestBody SysUser user) {
        return userService.loadUserByUsername(user.getUsername());
    }

    @PostMapping("register")
    @ApiOperation(value = "register", tags = "注册")
    public SysUser register(@RequestBody SysUser user) {
        return userService.register(user);
    }

    @DeleteMapping("delete")
    @ApiOperation(value = "delete", tags = "删除")
    public SysUser delete(Long id) {
        return userService.delete(id);
    }

    @PutMapping("enable")
    @ApiOperation(value = "enable", tags = "账户启用/禁用")
    public SysUser enabled(Long id) {
        return userService.enabled(id);
    }

    private final SysUserService userService;

    public SysUserController(SysUserService userService) {
        this.userService = userService;
    }
}
