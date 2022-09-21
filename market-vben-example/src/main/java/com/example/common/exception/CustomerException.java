package com.example.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常信息类
 */
public class CustomerException extends RuntimeException {

    private HttpStatus status;

    public CustomerException() {
        this.status = HttpStatus.GONE;
    }

    public CustomerException(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
