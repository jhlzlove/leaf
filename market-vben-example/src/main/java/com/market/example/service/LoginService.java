package com.market.example.service;

import com.market.example.domain.SysUser;
import com.market.example.utils.ResResult;

/**
 * @author clf
 * @time 2022/8/13 17:59
 * @desc: LoginService
 */
public interface LoginService {

    ResResult login(SysUser user);
}
