package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysDept;
import com.example.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("list")
    @ApiOperation(value = "listDept", notes = "部门列表")
    public List<SysDept> listDept() {
        return sysDeptService.list();
    }

    private final SysDeptService sysDeptService;

    public SysDeptController(SysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }
}
