package com.leaf.framework.interceptor;

import com.leaf.framework.annotation.Log;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.Arrays;

/**
 * 日志功能实现
 *
 * @author jhlz
 * @version 1.0.0
 */
@Log
@Interceptor
@Priority(6000)
public class LogInterceptor {


    @AroundInvoke
    public Object logging(InvocationContext ctx) throws Exception {
        // log.info("请求方法: {}", ctx.getMethod());
        // log.info("请求方法参数个数: {}", ctx.getMethod().getParameterCount());
        // log.info("请求方法返回类型: {}", ctx.getMethod().getReturnType());

        System.out.println("请求方法: " + ctx.getMethod());
        Arrays.stream(ctx.getMethod().getAnnotations()).forEach(System.out::println);
        // log.info("请求参数: {}", ctx.getParameters().toString());
        Object proceed = ctx.proceed();
        return proceed;
    }

}
