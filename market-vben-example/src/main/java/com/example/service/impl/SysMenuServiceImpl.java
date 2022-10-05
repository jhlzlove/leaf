package com.example.service.impl;

import com.example.common.exception.CustomerException;
import com.example.common.utils.SpringUtil;
import com.example.domain.SysMenu;
import com.example.repository.SysMenuDao;
import com.example.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jhlz
 * @time 2022/8/29 12:58
 * @desc: SysMenuServiceImpl
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Override
    public List<SysMenu> listMenu(String menuName, String status) {
        List<SysMenu> allMenu = menuDao.findAll();
        List<SysMenu> treeMenu = buildMenuTree(allMenu, 0L);
        List<SysMenu> result = new ArrayList<>();

        if (Objects.isNull(menuName) && Objects.isNull(status)) {
            return treeMenu;
        }

        if (!ObjectUtils.isEmpty(menuName) && !ObjectUtils.isEmpty(status)) {
            result.addAll(allMenu.stream()
                    .filter(r -> Objects.equals(r.getMenuName(), menuName) &&
                            Objects.equals(r.getStatus(), status))
                    .collect(Collectors.toList()));
        } else if (!ObjectUtils.isEmpty(status)) {
            result.addAll(allMenu.stream()
                    .filter(r -> Objects.equals(r.getStatus(), status))
                    .collect(Collectors.toList()));
        } else if (!ObjectUtils.isEmpty(menuName)) {
            result.addAll(allMenu.stream()
                    .filter(r -> Objects.equals(r.getMenuName(), menuName))
                    .collect(Collectors.toList()));
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public void deleteById(Long id) {
        menuDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysMenu saveOrUpdate(SysMenu menu) {
        SysMenu saveOrUpdateMenu = menuDao.findById(menu.getId()).orElseGet(SysMenu::new);
        BeanUtils.copyProperties(menu, saveOrUpdateMenu, SpringUtil.getNullPropertyNames(menu));
        saveOrUpdateMenu.setUpdateTime(LocalDateTime.now());
        return menuDao.save(saveOrUpdateMenu);
    }

    /**
     * 构建菜单树
     *
     * @param menuList 菜单
     * @param pid      pid
     * @return
     */
    private List<SysMenu> buildMenuTree(List<SysMenu> menuList, Long pid) {
        List<SysMenu> resultList = new ArrayList<>();
        menuList.stream().forEach(menu -> {
            if (Objects.equals(menu.getParentId(), pid)) {
                menu.setChildren(buildMenuTree(menuList, menu.getId()));
                resultList.add(menu);
            }
        });
        return resultList;
    }

    private static final Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
    private final SysMenuDao menuDao;

    public SysMenuServiceImpl(SysMenuDao menuDao) {
        this.menuDao = menuDao;
    }

}
