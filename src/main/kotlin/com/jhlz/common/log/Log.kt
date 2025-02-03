package com.jhlz.common.log

import com.jhlz.constant.BusinessType
import jakarta.enterprise.util.Nonbinding
import jakarta.interceptor.InterceptorBinding
import java.lang.annotation.Inherited

/**
 * 操作日志注解
 */
@Inherited
@InterceptorBinding
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
    @get:Nonbinding
    val module: String = "",

    /**
     * 模块详情
     *
     * @return 模块详情
     */
    @get:Nonbinding
    val info: String = "",

    /**
     * 业务操作类型
     *
     * @return BusinessEnum 枚举
     */
    @get:Nonbinding
    val businessType: BusinessType = BusinessType.OTHER
)
