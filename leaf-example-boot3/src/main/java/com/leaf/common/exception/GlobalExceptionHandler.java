package com.leaf.common.exception;

import com.leaf.common.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.NoPermissionException;
import java.util.Objects;

/**
 * 全局异常信息处理
 *
 * @author: jhlz
 * @since: 2022/12/13 20:40:10
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
        BusinessException exception =
                Objects.isNull(be) ? BusinessException.UNKNOWN : be;
        return Response.error(exception.getCode(), exception.getMessage());
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

    @ExceptionHandler({NoPermissionException.class,
            UsernameNotFoundException.class})
    public ProblemDetail permissionExceptionHandler(HttpServletRequest req, Exception e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
