package com.leaf.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leaf.business.BusinessException;
import com.leaf.common.util.JSON;

import java.io.Serializable;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @version 1.0.0
 */
public record Response(
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
    public static Response ok() {
        return ok(null);
    }

    public static Response ok(Object data) {
        return ok(200, "操作成功！", data);
    }

    public static Response ok(int code, String message, Object data) {
        return ok(code, message, null, data);
    }

    public static Response error(BusinessException exception) {
        return ok(exception.getCode(), exception.getMessage(), null);
    }

    public static Response error(int code, String message) {
        return ok(code, message, null);
    }

    public static Response error(int code, String message, String description) {
        return ok(code, message, description, null);
    }

    public static Response error() {
        return ok(500, "操作失败！", null, null);
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
    private static Response ok(int code, String message, String description, Object data) {
        return new Response(code, message, description, data);
    }

    @Override
    public String toString() {
        return JSON.toJson(this);
    }
}
