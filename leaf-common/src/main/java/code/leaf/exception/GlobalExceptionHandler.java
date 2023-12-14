package com.leaf.common.exception;

import code.leaf.response.Response;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.leaf.common.business.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 全局异常信息处理
 *
 * @author jhlz
 * @since 2022/12/13 20:40:10
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获 GlobalException 异常处理
     *
     * @param req request
     * @param e   异常信息
     * @return ResultResponse
     */
    @ExceptionHandler(GlobalException.class)
    public Response exceptionHandler(HttpServletRequest req, GlobalException e) {
        BusinessException be = e.getException();
        BusinessException exception = Objects.isNull(be) ? BusinessException.UNKNOWN : be;
        return Response.error(exception.getCode(), "请求：{} 错误！" + req.getRequestURI() + exception.getMessage());
    }

    /**
     * security 相关
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler({BadCredentialsException.class})
    public ProblemDetail securityHandler(HttpServletRequest req, Exception e) {
        if (e instanceof BadCredentialsException) {
            return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误！");
        }
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    /**
     * jwt 相关
     */
    @ExceptionHandler({JWTVerificationException.class, AlgorithmMismatchException.class,
            TokenExpiredException.class, InvalidClaimException.class})
    public ProblemDetail jwtHandler(HttpServletRequest req, Exception e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    /**
     * 其它异常处理
     *
     * @param req 请求对象
     * @param e   异常
     * @return ProblemDetail
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail exceptionHandler(HttpServletRequest req, Exception e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
