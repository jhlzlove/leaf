package com.leaf.service;

import com.leaf.domain.LeafUser;

/**
 * @author jhlz
 * @version 1.0.0
 */
public interface RegisterService {
    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 是否成功
     */
    boolean register(LeafUser user);
}
