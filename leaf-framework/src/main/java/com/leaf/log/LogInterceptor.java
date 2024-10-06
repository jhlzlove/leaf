package com.leaf.log;

import com.leaf.annotation.Log;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Log
@Interceptor
public class LogInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @AroundInvoke
    public Object logging(InvocationContext context) throws Exception {
        log.info("args：{}", context.getParameters().toString());
        log.info("method:{}", context.getMethod().getName());
        log.info("class:{}", context.getMethod().getDeclaringClass().getName());
        log.info("args:{}", context.getContextData().toString());
        log.info("{}", context.getTimer());
        System.out.println("1111111111111111111111111111");
        Object proceed = context.proceed();

        System.out.println("222222222222222222222222222222");
        log.info("执行完成输出");
        return proceed;
    }
}
