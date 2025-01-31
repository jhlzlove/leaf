package com.jhlz.constant

import java.io.File

/**
 * 全局常量信息
 *
 * @author jhlz
 * @version 1.0.0
 */
object AppConstants {
    const val LEAF: String = "leaf_"

    // 文件上传路径
    val UPLOAD_PATH: String = "data" + File.separator + "upload"

    /**
     * login success generate with token username key
     */
    const val LOGIN_REDIS_KEY: String = "login_user_name:"

    /**
     * 登录 redis 缓存的时间，单位：秒
     */
    const val LOGIN_REDIS_EXPIRED: Int = 30
    const val JWT_PAYLOAD: String = "payload"
    const val BEARER_TOKEN: String = "Bearer "
    const val BASIC_TOKEN: String = "Basic "
    const val TOKEN: String = "token"

    // 过期时间
    const val EXPIRED: String = "expired"
    const val AUTHORIZATION: String = "Authorization"
}
