package com.example.common.exception;

/**
 * 业务异常信息枚举
 */
public enum BusinessException {
    UNKNOWN(100000, "未知异常!"),
    NOT_AUTHENTICATION(100001, "用户未认证！"),
    NOT_AUTHORIZATION(100002, "无权访问该资源！"),
    FAILED_AUTHORIZATION(100003, "登录失败！"),
    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public BusinessException setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public BusinessException setCode(int code) {
        this.code = code;
        return this;
    }
}
