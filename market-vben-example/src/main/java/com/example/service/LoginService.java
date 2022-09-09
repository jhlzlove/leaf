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
    LoginUserInfo login(SysUser user);

    /**
     * @return 用户信息
     */
    SysUser getUserInfo();
}
