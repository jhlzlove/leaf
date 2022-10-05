package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysRole;
import com.example.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getRoleListByPage")
    @ApiOperation(value = "listByPage", notes = "角色分页列表")
    public void listByPage(int page, int pageSize) {
        sysRoleService.listByPage(page, pageSize);
    }

    @GetMapping("list")
    @ApiOperation(value = "listByPage", notes = "角色分页列表")
    public List<SysRole> list() {
        return sysRoleService.list();
    }

    @PostMapping
    @ApiOperation(value = "save", notes = "添加")
    public SysRole save(SysRole role) {
        return sysRoleService.saveOrUpdate(role);
    }

    @DeleteMapping
    @ApiOperation(value = "deleteById", notes = "删除")
    public void deleteById(Long id) {
        sysRoleService.deleteById(id);
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "更新")
    public SysRole update(SysRole role) {
        return sysRoleService.saveOrUpdate(role);
    }

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }
}
