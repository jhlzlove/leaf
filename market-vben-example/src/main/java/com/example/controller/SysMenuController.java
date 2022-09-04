package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysMenu;
import com.example.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jhlz
 * @time 2022/8/29 12:45
 * @desc: SysMenuController
 */
@Api(value = "SysMenuController", tags = "菜单管理")
@ApiRestController
@RequestMapping("system/menu")
public class SysMenuController {

    @ApiOperation(value = "listmenu", notes = "菜单列表")
    @GetMapping("list")
    public List<SysMenu> getMenuList() {
        return menuService.getMenuList();
    }

    private final SysMenuService menuService;

    @Autowired
    public SysMenuController(SysMenuService menuService) {
        this.menuService = menuService;
    }
}
