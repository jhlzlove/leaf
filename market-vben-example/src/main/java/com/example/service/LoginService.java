package com.example.service;

import com.example.domain.SysUser;

public interface LoginService {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public abstract SysUser login(SysUser user);
}
