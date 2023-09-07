package com.leaf.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leaf.common.util.JSON;

import java.io.Serializable;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @since 2022/10/3 16:19:42
 */
public record Response(
        /* 状态码 */
        int code,
        /* 信息 */
        String message,
        /* 数据 */
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        Object data
) implements Serializable {
    public static Response success() {
        return success(ResponseEnum.SUCCESS, null);
    }

    public static Response success(int code, String message, Object data) {
        return new Response(code, message, data);
    }

    public static Response success(Object data) {
        return success(ResponseEnum.SUCCESS, data);
    }

    public static Response success(ResponseEnum resultEnum, Object data) {
        return success(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

    public static Response error(ResponseEnum resultEnum) {
        return success(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static Response error(int code, String message) {
        return success(code, message, null);
    }

    public static Response error() {
        return error(ResponseEnum.ERROR);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
