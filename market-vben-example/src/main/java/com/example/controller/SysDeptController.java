package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysDept;
import com.example.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jhlz
 * @desc: SysDeptController
 * @since 2022/9/8 18:11:12
 */
@Api(value = "SysDeptController", tags = "部门管理")
@RequestMapping("system/dept")
@ApiRestController
public class SysDeptController {

    @GetMapping
    @ApiOperation(value = "listDeptTree", notes = "部门列表")
    public List<SysDept> listDeptTree(String deptName, Boolean status) {
        return deptService.listDeptTree(deptName, status);
    }

    @PostMapping
    @ApiOperation(value = "save", notes = "添加")
    public SysDept save(@RequestBody SysDept dept) {
        return deptService.saveOrUpdate(dept);
    }

    @DeleteMapping
    @ApiOperation(value = "deleteById", notes = "删除")
    public void deleteById(Long id) {
        deptService.deleteById(id);
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "更新")
    public SysDept update(@RequestBody SysDept dept) {
        return deptService.saveOrUpdate(dept);
    }

    private final SysDeptService deptService;

    public SysDeptController(SysDeptService deptService) {
        this.deptService = deptService;
    }
}
