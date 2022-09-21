package com.example.common.annotation;

import com.example.common.logs.OperEnum;

import java.lang.annotation.*;

/**
 * 操作日志注解
 */
@Target(ElementType.METHOD) // 注解放置的目标位置
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented
public @interface OperLog {

    /**
     * 操作模块
     *
     * @return
     */
    String module() default "";

    /**
     * 操作类型（0其它 1新增 2修改 3删除）
     *
     * @return
     */
    int businessType() default 0;

    /**
     * 操作说明
     *
     * @return
     */
    OperEnum oper() default OperEnum.UNKNOWN;

}
