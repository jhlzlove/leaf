package com.jhlz.common.log

import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton

/**
 * @author jhlz
 * @version x.x.x
 */
@Singleton
@InterceptorBean(Log::class)
class LogInterceptor : MethodInterceptor<Any, Any>{

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any {
        println("调用方法名称：" + context.methodName + "调用方法参数：" + context.parameterValues)
        return context.proceed()
    }
}