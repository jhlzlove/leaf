package com.example.common.exception;

/**
 * BizException
 */
public class BizException extends RuntimeException {

    private ResultStatus status;

    public BizException() {
        this.status = ResultStatus.Common.ERROR_UNKNOWN;
    }

    public BizException(ResultStatus resultStatus) {
        this.status = resultStatus;
    }

    @Override
    public String getMessage() {
        return this.status.getMsg();
    }

    public ResultStatus getStatus() {
        return this.status;
    }
}
