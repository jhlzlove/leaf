package com.leaf.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 一般情况下，每个Controller接口的响应内容会被包装一层统一的响应格式，而有一些特殊情况并不想做这个处理，此时可以通过这个注解取消这个处理。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotWrapResponse {
}
