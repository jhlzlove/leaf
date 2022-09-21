package com.example.service;

import com.example.domain.SysMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 获取菜单列表
     *
     * @return
     */
    List<SysMenu> listMenu(String menuName, String status);

    SysMenu save(SysMenu menu);

    void deleteById(Long id);

    SysMenu update(SysMenu menu);
}
