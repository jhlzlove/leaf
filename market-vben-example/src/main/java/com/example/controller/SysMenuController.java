package com.example.controller;

import com.example.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @time 2022/8/29 12:45
 * @desc: SysMenuController
 */
@Api(value = "SysMenuController", tags = "菜单管理")
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @ApiOperation(value = "", tags = "菜单列表")
    @GetMapping("list")
    public void getMenuList() {
        menuService.getMenuList();
    }

    private final SysMenuService menuService;

    @Autowired
    public SysMenuController(SysMenuService menuService) {
        this.menuService = menuService;
    }
}
