package com.leaf.business;

/**
 * 业务异常信息枚举
 */
public enum BusinessException {
    UNKNOWN(100000, "未知异常!"),
    NOT_AUTHENTICATION(501, "用户未登录！"),
    TOKEN_AUTHENTICATION(100001, "token 验证失败！"),
    TOKEN_EXPIRED(100002, "token 验证失败！"),
    NOT_AUTHORIZATION(100002, "无权访问该资源！"),
    FAILED_AUTHORIZATION(100003, "登录失败！"),
    TIMEOUT_AUTHORIZATION(100004, "登录超时！"),
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
