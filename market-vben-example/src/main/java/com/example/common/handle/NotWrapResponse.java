package com.example.common.handle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NotWrapResponse
 * <p>
 * 指定一个Controller接口的响应不被包装
 * <p>
 * 一般情况下，每个Controller接口的响应内容会被包装一层统一的响应格式，而有一些特殊情况并不想做这个处理，此时可以通过这个注解取消这个处理。
 *
 * @author linqunxun
 * @date 2021/9/14 4:49 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotWrapResponse {
}
