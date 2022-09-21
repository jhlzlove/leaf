package com.example.common.exception;

import com.example.common.response.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局的异常处理器
 * 该处理将所有异常统一处理，对外提供统一的错误码和返回的格式
 */
@Slf4j
// @ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务相关异常捕获拦截
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<?> exceptionHandler(CustomerException e) {
        HttpStatus status = HttpStatus.OK;
        RespResult result = new RespResult(null, status.value(), e.getMessage(), null, null);
        log.error(e.getMessage(), e);
        return ResponseEntity.status(status).body(result);
    }

    /**
     * @param e 系统无法定义的错误捕获
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> exceptionHandler(Throwable e) {
        RespResult result = new RespResult(null, 520, "未知错误", null, null);
        if (e instanceof HttpClientErrorException) {
            result = handleHttpClientErrorException((HttpClientErrorException) e);
        } else if (e instanceof NoHandlerFoundException) {
            result = handleNoHandlerFoundException((NoHandlerFoundException) e);
        }
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    /**
     * 客户端异常400+
     *
     * @param e
     * @return
     */
    private RespResult handleHttpClientErrorException(HttpClientErrorException e) {
        HttpStatus respStatus;
        switch (e.getStatusCode()) {
            case NOT_FOUND:
                respStatus = HttpStatus.NOT_FOUND;
                break;
            default:
                respStatus = HttpStatus.BAD_REQUEST;
        }
        return buildErrorResponse(respStatus, null);
    }

    /**
     * 找不到资源异常
     *
     * @param e
     * @return
     */
    private RespResult handleNoHandlerFoundException(NoHandlerFoundException e) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    /**
     * 构建异常返回体
     *
     * @param status 状态码枚举
     * @return
     */
    private RespResult buildErrorResponse(HttpStatus status, String detail) {
        return new RespResult(null, status.value(), status.getReasonPhrase(), detail, null);
    }

}
