package com.jhlz.common.log

import jakarta.annotation.Priority
import jakarta.interceptor.AroundInvoke
import jakarta.interceptor.Interceptor
import jakarta.interceptor.InvocationContext

/**
 * @author jhlz
 * @version x.x.x
 */
@Log
@Priority(Interceptor.Priority.APPLICATION + 1)
@Interceptor
class LogInterceptor {

    @AroundInvoke
    fun logging(ctx: InvocationContext): Any? {
        val method = ctx.method
        val ann = method.getAnnotation(Log::class.java)
        println("请求方法 $method")
        println("请求模块 ${ann.module} 模块说明 ${ann.info} 操作类型 ${ann.businessType}")
        val proceed = ctx.proceed()
        return proceed
    }
}