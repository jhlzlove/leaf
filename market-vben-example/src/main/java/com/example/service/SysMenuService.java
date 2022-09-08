package com.example.service;

import com.example.domain.SysMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 获取菜单列表
     *
     * @return
     */
    public abstract List<SysMenu> getMenuList(String menuName, String status);
}
