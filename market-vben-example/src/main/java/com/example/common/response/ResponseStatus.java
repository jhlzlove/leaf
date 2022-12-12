package com.example.common.response;

import org.springframework.util.Assert;

import java.util.Objects;

/**
 * 响应状态枚举
 *
 * @author jhlz
 * @since 2022/10/3 16:19:24
 */
public enum ResponseStatus {
    SUCCESS(200, "请求成功！"),
    ERROR(500, "请求失败！"),
    NOT_FOUND(404, "找不到资源！"),
    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态说明
     */
    private String message;

    public String ofValue(int code) {
        Assert.notNull(code, "code must is not null!");
        for (ResponseStatus status : ResponseStatus.values()) {
            if (Objects.equals(code, status.getCode())) {
                return status.getMessage();
            }
        }
        return null;
    }

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public ResponseStatus setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseStatus setMessage(String message) {
        this.message = message;
        return this;
    }
}