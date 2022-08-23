package com.example.common.exception;

import com.example.common.response.RespResult;
import com.example.common.response.RespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.stream.Collectors;

/**
 * 全局的异常处理器
 * 该处理将所有异常统一处理，对外提供统一的错误码和返回的格式
 */
@Slf4j
@ControllerAdvice
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
        if (e.getStatus() == RespStatus.Common.ERROR_SESSION_ERROR) {
            status = HttpStatus.OK;
        }
        RespResult result = new RespResult(null, e.getStatus().getCode(), e.getStatus().getMessage(), null, null);
        log.error(e.getMessage(), e);
        return ResponseEntity.status(status).body(result);
    }

    /**
     * @param e 系统无法定义的错误捕获
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> exceptionHandler(Throwable e) {
        RespResult result;
        if (e instanceof HttpClientErrorException) {
            result = handleHttpClientErrorException((HttpClientErrorException) e);
        }
        /*else if (e instanceof ConstraintViolationException) {
            result = handleConstraintViolationException((ConstraintViolationException) e);
        }*/
        else if (e instanceof MethodArgumentNotValidException) {
            result = handleMethodArgumentNotValidException((MethodArgumentNotValidException) e);
        } else if (e instanceof BindException) {
            result = handleBindException((BindException) e);
        } else if (e instanceof NoHandlerFoundException) {
            result = handleNoHandlerFoundException((NoHandlerFoundException) e);
        } else if (e instanceof HttpMessageConversionException) {
            result = buildErrorResponse(RespStatus.Common.ERROR_PARAM_NOT_VALID, null);
        } else {
            result = buildErrorResponse(RespStatus.Common.ERROR_UNKNOWN, null);
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
        RespStatus respStatus;
        switch (e.getStatusCode()) {
            case UNAUTHORIZED:
                respStatus = com.example.common.response.RespStatus.Common.ERROR_SESSION_ERROR;
                break;
            case FORBIDDEN:
                respStatus = com.example.common.response.RespStatus.Common.ERROR_SESSION_ERROR;
                break;
            case NOT_FOUND:
                respStatus = com.example.common.response.RespStatus.Common.NOT_FOUND;
                break;
            default:
                respStatus = com.example.common.response.RespStatus.Common.ERROR_UNKNOWN;
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
        return buildErrorResponse(RespStatus.Common.NOT_FOUND, e.getMessage());
    }

    /**
     * @param e 普通方法参数验证失败时, 比如NotEmpty
     */
   /* private ResponseResult handleConstraintViolationException(ConstraintViolationException e) {
        return buildErrorResponse(RespStatus.Common.ERROR_PARAM_NOT_VALID, e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(" / ")));
    }*/

    /**
     * @param e @RequestBody验证失败
     */
    private RespResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return buildErrorResponse(RespStatus.Common.ERROR_PARAM_NOT_VALID, e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" / ")));
    }

    /**
     * @param e @Valid实体参数验证失败时
     */
    private RespResult handleBindException(BindException e) {
        return buildErrorResponse(RespStatus.Common.ERROR_PARAM_NOT_VALID, e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" / ")));
    }

    /**
     * 构建异常返回体
     *
     * @param status 状态码枚举
     * @return
     */
    private RespResult buildErrorResponse(RespStatus status, String detail) {
        return new RespResult(null, status.getCode(), status.getMessage(), detail, null);
    }

}
