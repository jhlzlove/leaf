package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysUser;
import com.example.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @time 2022/9/1 8:37
 * @desc: SysUserController
 */
@ApiRestController
@RequestMapping("system/account")
@Api(value = "SysUserController", tags = "用户管理")
public class SysUserController {
    @PostMapping("register")
    @ApiOperation(value = "register", notes = "用户注册")
    public SysUser register(@RequestBody SysUser user) {
        return userService.saveOrUpdate(user);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "delete", notes = "删除")
    public SysUser delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "enable", notes = "账户启用/禁用")
    public SysUser enabled(@PathVariable Long id) {
        return userService.enabled(id);
    }

    @PutMapping()
    @ApiOperation(value = "update", notes = "账户更新")
    public SysUser update(@RequestBody SysUser user) {
        return userService.update(user);
    }

    @GetMapping("list")
    @ApiOperation(value = "list", notes = "账户列表")
    public Page<SysUser> list(int page, int pageSize) {
        return userService.list(page, pageSize);
    }

    private final SysUserService userService;

    public SysUserController(SysUserService userService) {
        this.userService = userService;
    }
}
