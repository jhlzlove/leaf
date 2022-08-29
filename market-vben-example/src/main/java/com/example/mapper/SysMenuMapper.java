package com.example.mapper;

import com.example.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu menu);

    int insertSelective(SysMenu menu);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenu menu);

    int updateByPrimaryKey(SysMenu menu);

    /**
     * @return 所有菜单
     */
    List<SysMenu> listMenu();
}