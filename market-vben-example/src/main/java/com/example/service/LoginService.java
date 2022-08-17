package com.example.service;

import com.example.common.utils.ResResult;
import com.example.domain.SysUser;

/**
 * @author clf
 * @time 2022/8/13 17:59
 * @desc: LoginService
 */
public interface LoginService {
    ResResult login(SysUser user);
}
