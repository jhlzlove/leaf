package com.leaf.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpringSecurityExceptionHandler {
    /**
     * security 相关
     *
     * @param req 请求对象
     * @param e   异常
     * @return ProblemDetail
     */
    @ExceptionHandler({BadCredentialsException.class})
    public ProblemDetail securityHandler(HttpServletRequest req, Exception e) {
        if (e instanceof BadCredentialsException) {
            return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误！");
        }
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
