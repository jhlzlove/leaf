package com.example.common.response;

import com.example.common.utils.JSONUtil;
import lombok.Data;

import java.util.Optional;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @since 2022/10/3 16:19:42
 */
@Data
public class R {
    /**
     * 结果对象
     **/
    private Object data;

    /**
     * 状态码
     **/
    private int code;

    /**
     * 信息
     **/
    private String message;

    public R() {
    }

    /**
     * 默认成功处理
     *
     * @return
     */
    public static R success() {
        return success(RespStatus.SUCCESS);
    }

    public static R success(RespStatus status) {
        return success(status.getCode(), success().getMessage());
    }

    public static R success(int code, String message) {
        return success(code, message, null);
    }

    public static R success(Object data) {
        R resp = success(RespStatus.SUCCESS.getCode(), RespStatus.SUCCESS.getMessage(), data);
        return resp;
    }

    public static R success(int code, String message, Object data) {
        R resp = new R();
        resp.setCode(code);
        resp.setMessage(message);
        Optional.ofNullable(data).ifPresent(d -> resp.setData(d));
        return resp;
    }

    /**
     * 默认失败处理
     *
     * @return
     */
    public static R error() {
        return error(RespStatus.ERROR);
    }

    public static R error(RespStatus status) {
        return error(status.getCode(), status.getMessage());
    }

    public static R error(int code, String message) {
        R resp = new R();
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonString(this);
    }
}
