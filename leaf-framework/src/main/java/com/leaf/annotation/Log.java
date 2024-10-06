package com.leaf.annotation;

import com.leaf.business.BusinessEnum;
import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

/**
 * 操作日志注解
 */
@Inherited
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 操作模块
     *
     * @return 日志模块
     */
    String module() default "";

    /**
     * 操作说明
     *
     * @return BusinessEnum 枚举
     */
    BusinessEnum operation() default BusinessEnum.UNKNOWN;

}
