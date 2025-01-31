package com.jhlz.common.log

import com.jhlz.exception.BusinessEnum
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
     * 操作模块
     *
     * @return 日志模块
     */
    @get:Nonbinding
    val module: String = "",
    /**
     * 操作说明
     *
     * @return BusinessEnum 枚举
     */
    @get:Nonbinding
    val operation: BusinessEnum = BusinessEnum.UNKNOWN
)
