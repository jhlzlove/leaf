package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysRole;
import com.example.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jhlz
 * @desc: SysRoleController
 * @since 2022/9/8 18:14:49
 */
@Api(value = "SysDeptController", tags = "角色管理")
@RequestMapping("system/role")
@ApiRestController
public class SysRoleController {
    @GetMapping("list")
    @ApiOperation(value = "listRole", notes = "角色列表")
    public List<SysRole> listRole() {
        return sysRoleService.list();
    }

    @GetMapping("getRoleListByPage")
    @ApiOperation(value = "getRoleListByPage", notes = "角色分页列表")
    public void getRoleListByPage(int page, int pageSize) {
        sysRoleService.getRoleListByPage(page, pageSize);
    }

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }
}
