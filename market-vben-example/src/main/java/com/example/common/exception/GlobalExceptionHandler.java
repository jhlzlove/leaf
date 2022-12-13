package com.example.common.exception;

import com.example.common.response.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
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
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public R exceptionHandler(HttpServletRequest req, GlobalException e) {
        BusinessException be = e.getException();
        BusinessException exception =
                Objects.isNull(be) ? BusinessException.UNKNOWN : be;
        return R.error(exception.getCode(), exception.getMessage());
    }

}
