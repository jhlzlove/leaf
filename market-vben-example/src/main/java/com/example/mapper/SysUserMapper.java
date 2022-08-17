package com.example.mapper;

import com.example.domain.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser loadByUserName(String username);

    Integer updatePassword(@Param("username") String username,
                           @Param("newPassword") String newPassword);
}