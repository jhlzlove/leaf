package com.example.mapper;

import com.example.domain.SysUser;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser loadByUserName(String username);

    List<String> selectAllPermissions(String username);
}