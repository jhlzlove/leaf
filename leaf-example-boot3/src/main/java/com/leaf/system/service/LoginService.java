package com.leaf.system.service;

import com.leaf.system.domain.User;

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
    String login(User user);

    /**
     * 登出
     */
    void logout();
}
