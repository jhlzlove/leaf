package com.leaf.system.service;

import com.leaf.common.response.Response;
import com.leaf.system.domain.record.LoginUserRecord;

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
