package com.leaf.exception;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.leaf.business.BusinessException;
import com.leaf.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常信息处理
 *
 * @author jhlz
 * @version 1.0.0
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
        BusinessException exception = ObjectUtils.isEmpty(be) ? BusinessException.UNKNOWN : be;
        return Response.error(exception.getCode(), "请求：{} 错误！" + req.getRequestURI() + exception.getMessage());
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
