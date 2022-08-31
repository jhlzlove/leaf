package com.example.service.impl;

import com.example.domain.SysMenu;
import com.example.repository.SysMenuDao;
import com.example.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jhlz
 * @time 2022/8/29 12:58
 * @desc: SysMenuServiceImpl
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    private final SysMenuDao sysMenuDao;

    public SysMenuServiceImpl(SysMenuDao sysMenuDao) {
        this.sysMenuDao = sysMenuDao;
    }

    @Override
    public List<SysMenu> getMenuList() {
        List<SysMenu> list = sysMenuDao.findAll();
        return list;
    }
}
