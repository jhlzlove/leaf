package com.leaf.exception;


import com.leaf.business.BusinessException;

/**
 * 自定义异常信息类
 *
 * @author jhlz
 * @version 1.0.0
 */
public class GlobalException extends RuntimeException {

    private final BusinessException exception;

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public GlobalException(BusinessException exception) {
        super();
        this.exception = exception;
    }

    public BusinessException getException() {
        return exception;
    }
}
