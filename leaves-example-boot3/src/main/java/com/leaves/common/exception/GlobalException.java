package com.leaves.common.exception;

/**
 * 自定义异常信息类
 *
 * @author jhlz
 * @since 2022/12/13 20:40
 */
public class GlobalException extends RuntimeException {

    private BusinessException exception;

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
