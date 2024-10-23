package com.leaf.common.record;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leaf.common.util.JSON;

import java.io.Serializable;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @version 1.0.0
 */
public record R(
        /* 状态码 */
        int status,
        /* 信息 */
        String message,
        /* 信息描述 */
        String description,
        /* 数据 */
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        Object data
) implements Serializable {
    public static R ok() {
        return ok(null);
    }

    public static R ok(Object data) {
        return ok(200, "操作成功！", data);
    }

    public static R ok(int code, String message, Object data) {
        return ok(code, message, null, data);
    }

    public static R error() {
        return error(500, "内部错误！");
    }

    public static R error(String message) {
        return error(500, message);
    }

    public static R error(int code, String message) {
        return ok(code, message, null, null);
    }

    /**
     * 返回信息构造
     *
     * @param code        响应码
     * @param message     响应信息
     * @param description 响应信息详情
     * @param data        响应数据
     * @return Response 对象
     */
    private static R ok(int code, String message, String description, Object data) {
        return new R(code, message, description, data);
    }

    @Override
    public String toString() {
        return JSON.toJson(this);
    }
}
