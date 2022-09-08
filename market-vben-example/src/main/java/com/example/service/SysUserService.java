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
    public abstract SysUser register(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public abstract SysUser delete(Long id);

    /**
     * 启用禁用
     *
     * @param id
     * @return
     */
    public abstract SysUser enabled(Long id);

    /**
     * 用户信息更新
     *
     * @param user
     * @return
     */
    public abstract SysUser update(SysUser user);

    public abstract List<SysUser> list();
}
