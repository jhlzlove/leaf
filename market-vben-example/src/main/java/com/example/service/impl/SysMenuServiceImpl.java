package com.example.service.impl;

import com.example.domain.SysMenu;
import com.example.mapper.SysMenuMapper;
import com.example.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jhlz
 * @time 2022/8/29 12:58
 * @desc: SysMenuServiceImpl
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Override
    public List<SysMenu> getMenuList() {
        return menuMapper.listMenu();
    }

    private final SysMenuMapper menuMapper;

    @Autowired
    public SysMenuServiceImpl(SysMenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }
}
