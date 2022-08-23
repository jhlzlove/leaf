package com.example.service;

import com.example.domain.LoginUser;
import com.example.domain.SysUser;

/**
 * @author clf
 * @time 2022/8/13 17:59
 * @desc: LoginService
 */
public interface LoginService {
    LoginUser login(SysUser user);
}
