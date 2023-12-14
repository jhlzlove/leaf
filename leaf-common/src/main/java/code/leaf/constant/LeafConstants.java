package com.leaf.common.constant;

/**
 * 全局常量信息
 *
 * @author jhlz
 * @version 1.0.0
 * @since 2022/8/10 17:19
 */
public class LeafConstants {

    /**
     * login success generate with token username key
     */
    public static final String LOGIN_REDIS_KEY = "login_user_name:";
    /**
     * 登录 redis 缓存的时间，单位：秒
     */
    public static final int LOGIN_REDIS_EXPIRED = 30;
    public static final String JWT_PAYLOAD = "payload";
    public static final String BEARER_TOKEN = "Bearer ";
    public static final String BASIC_TOKEN = "Basic ";
    public static final String TOKEN = "token";
    // 过期时间
    public static final String EXPIRED = "expired";
    public static final String AUTHORIZATION = "Authorization";

}
