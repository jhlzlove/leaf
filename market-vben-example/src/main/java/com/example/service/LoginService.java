package com.example.service;

import com.example.domain.SysUser;
import com.example.domain.resp.LoginUserInfo;

public interface LoginService {

    /**
     * 登录
     *
     * @param user
     * @return LoginUserInfo
     */
    public abstract LoginUserInfo login(SysUser user);

    /**
     * @return 用户信息
     */
    public abstract SysUser getUserInfo();
}
