package com.example.service;

import com.example.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface SysUserService extends UserDetailsService, UserDetailsPasswordService {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    SysUser register(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    SysUser delete(Long id);

    /**
     * 启用禁用
     *
     * @param id
     * @return
     */
    SysUser enabled(Long id);

    /**
     * 用户信息更新
     *
     * @param user
     * @return
     */
    SysUser update(SysUser user);

    List<SysUser> list();
}
