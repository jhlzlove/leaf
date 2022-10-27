package com.example.common.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * LogAspect:
 *
 * @author jhlz
 * @since 2022/9/16 10:08:28
 */
@Aspect
@Component
public class LogAspect {


    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.example.common.annotation.OperationLog)")
    public void logPointCut() {
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
     */
    @Pointcut("execution(* com.example.controller.*.*(..))")
    public void exceptionLogPointCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行
     *
     * @param joinPoint 切入点
     * @param result    返回结果
     */
    @AfterReturning(value = "logPointCut()", returning = "result")
    public void saveOperationLog(JoinPoint joinPoint, Object result) {


    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "exceptionLogPointCut()", throwing = "e")
    public void saveExceptionOperationLog(JoinPoint joinPoint, Exception e) {

    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
        if (message.length() > 2000)
            message = message.substring(0, 500) + "..........." + message.substring(message.length() - 1500, message.length() - 1);
        return message;
    }
}
