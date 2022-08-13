package com.market.example.constant;

/**
 * 请求代码和消息的简单枚举类
 */
public enum RequestEnum {
    SUCCESS("200", "请求成功！"),
    ERROR("400", "请求失败！"),
    ;
    private String code;
    private String message;

    RequestEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
