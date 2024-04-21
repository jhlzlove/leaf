package com.leaf.service;

import com.leaf.domain.LeafUser;
import com.leaf.response.Response;

/**
 * @author jhlz
 * @version 1.0.0
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param user 登录对象
     * @return token
     */
    Response login(LeafUser user);

    Response register(LeafUser user);
}
