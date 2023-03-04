package com.leaf.common.log;

import com.leaf.common.annotation.OperationLog;
import com.leaf.common.business.BusinessEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志切面
 *
 * @author jhlz
 * @since 2022/9/16 10:08:28
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.leaf.common.annotation.OperationLog)")
    public void logPointCut() {
        log.info("---------------------- 正常操作日志 -------------------------");
    }

    /**
     * 设置操作异常切入点记录异常日志
     */
    @Pointcut("execution(* com.leaf.system..*.*(..))")
    public void exceptionLogPointCut() {
        log.info("---------------------- 异常操作日志 -------------------------");
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行
     *
     * @param joinPoint 切入点
     * @param result    返回结果
     */
    @AfterReturning(value = "logPointCut()", returning = "result")
    public void saveOperationLog(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 请求的模块信息
        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        BusinessEnum operation = operationLog.operation();
        log.info("operation : {}", operation);

        // 请求类
        Class<?> clazz = method.getDeclaringClass();
        // 请求方法
        String methodName = method.getName();
        // 请求参数
        Object[] args = joinPoint.getArgs();
        log.info("---------------------------操作内容------------------------");
        log.info("请求类：{}, 请求方法：{}, 请求参数： {}", clazz.getName(), methodName, args);

    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "exceptionLogPointCut()", throwing = "e")
    public void saveExceptionOperationLog(JoinPoint joinPoint, Exception e) {

        log.info("------------------异常操作--------------------");
        /* MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 请求的模块信息
        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        BusinessEnum operation = operationLog.operation();
        log.info("operation : {}", operation);

        // 请求类
        Class<?> clazz = method.getDeclaringClass();
        // 请求方法
        String methodName = method.getName();
        // 请求参数
        Object[] args = joinPoint.getArgs();
        log.info("请求类：{}, 请求方法：{}, 请求参数： {}", clazz.getName(), methodName, args); */

        log.info("{}", e.getMessage());
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stet : elements) {
            sb.append(stet).append("\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + sb;
        if (message.length() > 2000)
            message = message.substring(0, 500) + "..........." + message.substring(message.length() - 1500, message.length() - 1);
        return message;
    }
}
