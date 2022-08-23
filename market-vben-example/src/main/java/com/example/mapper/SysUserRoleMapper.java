package com.example.mapper;

import com.example.domain.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    /**
     * 根据 uid 获取关联关系
     *
     * @param uid
     * @return
     */
    SysUserRole selectByUid(Long uid);
}