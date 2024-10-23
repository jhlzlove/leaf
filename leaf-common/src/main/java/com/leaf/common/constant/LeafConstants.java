package com.leaf.common.constant;

import java.io.File;

/**
 * 全局常量信息
 *
 * @author jhlz
 * @version 1.0.0
 */
public class LeafConstants {

    public static final String LEAF = "leaf_";
    // 文件上传路径
    public static final String UPLOAD_PATH = "data" + File.separator + "upload";
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
