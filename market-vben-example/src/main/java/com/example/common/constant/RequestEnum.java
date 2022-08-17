package com.market.example.common.constant;

/**
 * 请求代码和消息的简单枚举类
 */
public enum RequestEnum {
    SUCCESS(200, "请求成功！"),
    ERROR(400, "请求失败！"),
    ;
    private Integer code;
    private String message;

    RequestEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
