package com.jhlz.common.log

import com.jhlz.constant.BusinessType
import io.micronaut.aop.Around

/**
 * 操作日志注解
 */
@Around
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS
)
@Retention(AnnotationRetention.RUNTIME)
annotation class Log(
    /**
     * 模块名称
     *
     * @return 模块名称
     */
    val module: String = "",

    /**
     * 模块详情
     *
     * @return 模块详情
     */
    val info: String = "",

    /**
     * 业务操作类型
     *
     * @return BusinessEnum 枚举
     */
    val businessType: BusinessType = BusinessType.OTHER
)
