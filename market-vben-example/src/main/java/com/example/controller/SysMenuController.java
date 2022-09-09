package com.example.controller;

import com.example.common.annotation.ApiRestController;
import com.example.domain.SysMenu;
import com.example.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @ApiOperation(value = "listmenu", notes = "菜单列表")
    public List<SysMenu> getMenuList(String menuName, String status) {
        return menuService.listMenu(menuName, status);
    }


    @PostMapping
    @ApiOperation(value = "save", notes = "添加")
    public SysMenu save(SysMenu menu) {
        return menuService.save(menu);
    }

    @DeleteMapping
    @ApiOperation(value = "deleteById", notes = "删除")
    public void deleteById(Long id) {
        menuService.deleteById(id);
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "更新")
    public SysMenu update(SysMenu menu) {
        return menuService.update(menu);
    }

    private final SysMenuService menuService;

    @Autowired
    public SysMenuController(SysMenuService menuService) {
        this.menuService = menuService;
    }
}
