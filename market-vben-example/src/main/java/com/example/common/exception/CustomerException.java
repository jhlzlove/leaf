package com.example.common.exception;

import com.example.common.response.RespStatus;

/**
 * 自定义异常信息类
 */
public class CustomerException extends RuntimeException {

    private RespStatus status;

    public CustomerException() {
        this.status = RespStatus.Common.ERROR_UNKNOWN;
    }

    public CustomerException(RespStatus resultStatus) {
        this.status = resultStatus;
    }

    @Override
    public String getMessage() {
        return this.status.getMessage();
    }

    public RespStatus getStatus() {
        return this.status;
    }
}
