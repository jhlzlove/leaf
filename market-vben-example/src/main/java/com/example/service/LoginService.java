package com.example.service;

import com.example.domain.SysUser;

import java.util.Map;

public interface LoginService {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public abstract Map<String, Object> login(SysUser user);
}
