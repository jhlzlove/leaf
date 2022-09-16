package com.example.common.logs;

import com.example.common.annotation.OperLog;
import com.example.common.utils.JSONUtil;
import com.example.common.utils.SecurityUtil;
import com.example.common.utils.ServletUtil;
import com.example.domain.SysOperLog;
import com.example.domain.resp.LoginUserInfo;
import com.example.service.SysOperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Optional;

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
    @Pointcut("@annotation(com.example.common.annotation.OperLog)")
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

        SysOperLog log = new SysOperLog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法签名
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog operLog = method.getAnnotation(OperLog.class);

            Optional.ofNullable(operLog).ifPresent(
                    o -> {
                        OperEnum oper = o.oper();
                        log.setModule(oper.getModule())
                                .setBusinessType(operLog.businessType())
                                .setOperDesc(oper.getDesc());
                    }
            );
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            // 设置请求方法
            log.setReqMethod(className + "." + methodName + "()");

            // 获取请求参数数组
            Object[] params = joinPoint.getArgs();
            String param = "空";

            if (params.length > 0) {
                param = argsArrayToString(params);
                if (param.length() > 2000) {
                    param = param.substring(0, 2000);
                }
            }
            log.setReqParam(param);
            // 获取当前用户
            LoginUserInfo loginUser = SecurityUtil.getLoginUser();
            // 设置用户信息
            log
                    .setOperTime(LocalDateTime.now())
                    .setDeptName(log.getDeptName());
            HttpServletRequest request = ServletUtil.getRequest();
            log.setReqUrl(request.getRequestURI());
            log.setReqMethod(request.getMethod());
            log.setStatus(0);
            // save
            logService.save(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "exceptionLogPointCut()", throwing = "e")
    public void saveExceptionOperationLog(JoinPoint joinPoint, Exception e) {
        SysOperLog exceptionLog = new SysOperLog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = method.getName();
            // 设置请求方法
            exceptionLog.setReqMethod(className + "." + methodName);
            exceptionLog.setStatus(1);
            exceptionLog.setOperDesc(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()));

            // save
            logService.save(exceptionLog);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (ObjectUtils.isEmpty(o)) {
                    try {
                        String jsonObj = JSONUtil.toJSON(o);
                        params += jsonObj + " ";
                    } catch (Exception e) {
                    }
                }
            }
        }
        return params.trim();
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

    private final SysOperLogService logService;

    public LogAspect(SysOperLogService logService) {
        this.logService = logService;
    }
}
