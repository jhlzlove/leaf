package com.leaf.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leaf.common.util.JSONUtil;

import java.io.Serializable;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @since 2022/10/3 16:19:42
 */
public record ResultResponse(
        /**
         * 状态码
         */
        int code,
        /**
         * 信息
         */
        String message,
        /**
         * 数据
         */
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        Object data
) implements Serializable {

    public ResultResponse(int code, String message) {
        this(code, message, null);
    }

    public static ResultResponse success() {
        return success(ResultEnum.SUCCESS, null);
    }

    public static ResultResponse success(int code, String message, Object data) {
        return new ResultResponse(code, message, data);
    }

    public static ResultResponse success(int code, String message) {
        return new ResultResponse(code, message);
    }

    public static ResultResponse success(Object data) {
        return success(ResultEnum.SUCCESS, data);
    }

    public static ResultResponse success(ResultEnum resultEnum, Object data) {
        return new ResultResponse(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

    public static ResultResponse error(ResultEnum resultEnum) {
        return new ResultResponse(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static ResultResponse error(int code, String message) {
        return new ResultResponse(code, message, null);
    }

    public static ResultResponse error() {
        return error(ResultEnum.ERROR);
    }

    @Override
    public String toString() {
        return JSONUtil.toJSONString(this);
    }
}
