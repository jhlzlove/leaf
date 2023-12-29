package com.leaf.service;

import com.leaf.domain.record.LoginUserRecord;
import com.leaf.response.Response;

/**
 * @author jhlz
 * @version 1.0.0
 * @since 2023/10/3 16:14
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param user 登录对象
     * @return token
     */
    Response login(LoginUserRecord user);

    Response register(LoginUserRecord user);
}
