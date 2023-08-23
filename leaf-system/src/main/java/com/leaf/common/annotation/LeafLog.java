package com.leaf.common.annotation;

import com.leaf.common.business.BusinessEnum;

import java.lang.annotation.*;

/**
 * 操作日志注解
 */
@Target(ElementType.METHOD) // 注解放置的目标位置
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented
public @interface LeafLog {

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
