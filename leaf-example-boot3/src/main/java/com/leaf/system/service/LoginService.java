package com.leaf.system.service;

import com.leaf.system.entity.LeafUser;

import java.util.Map;

/**
 * 登录接口
 *
 * @author jhlz
 * @since 2022/12/20 21:38
 */
public interface LoginService {

    /**
     * 登录接口
     *
     * @param user 账户信息
     * @return token
     */
    Map<String, ?> login(LeafUser user);

    /**
     * 登出
     */
    void logout();

    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return 用户信息
     */
    LeafUser register(LeafUser user);
}
