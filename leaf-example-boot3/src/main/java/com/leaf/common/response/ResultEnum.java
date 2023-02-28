package com.leaf.common.response;

/**
 * 响应状态枚举
 *
 * @author jhlz
 * @since 2022/10/3 16:19:24
 */
public enum ResultEnum {

    SUCCESS(200, "操作成功！"),
    ERROR(500, "操作失败！"),
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

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public ResultEnum setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultEnum setMessage(String message) {
        this.message = message;
        return this;
    }
}