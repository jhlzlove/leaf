package com.jhlz.common.log

import jakarta.annotation.Priority
import jakarta.interceptor.AroundInvoke
import jakarta.interceptor.Interceptor
import jakarta.interceptor.InvocationContext
import org.jboss.logging.Logger

/**
 * @author jhlz
 * @version x.x.x
 */
@Log
@Priority(Interceptor.Priority.APPLICATION + 1)
@Interceptor
class LogInterceptor(private val logger: Logger) {

    @AroundInvoke
    fun logging(ctx: InvocationContext): Any? {
        val method = ctx.method
        val ann = method.getAnnotation(Log::class.java)
        logger.info("请求方法 $method")
        logger.info("请求模块 ${ann.module}，请求操作 ${ann.operation}")
        val proceed = ctx.proceed()
        return proceed
    }
}