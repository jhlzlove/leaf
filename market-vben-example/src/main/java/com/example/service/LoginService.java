package com.example.service;

import com.example.domain.SysUser;
import com.example.domain.resp.LoginUserInfo;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService, UserDetailsPasswordService {

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
