package com.leaf.framework.exception;


/**
 * 自定义全局异常
 *
 * @author jhlz
 * @version 1.0.0
 */
public class ServiceException extends RuntimeException {

    private final BusinessException exception;

    @Override
    public String getMessage() {
        return exception.getMessage();
    }

    public ServiceException(BusinessException exception) {
        super();
        this.exception = exception;
    }

    public BusinessException getException() {
        return exception;
    }
}
