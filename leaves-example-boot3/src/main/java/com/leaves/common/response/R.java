package com.leaves.common.response;

import com.leaves.common.utils.JSONUtil;

import java.io.Serializable;
import java.util.Optional;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @since 2022/10/3 16:19:42
 */
public class R implements Serializable {
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
        return success(ResponseStatus.SUCCESS);
    }

    public static R success(ResponseStatus status) {
        return success(status.getCode(), success().getMessage());
    }

    public static R success(int code, String message) {
        return success(code, message, null);
    }

    public static R success(Object data) {
        R resp = success(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMessage(), data);
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
        return error(ResponseStatus.ERROR);
    }

    public static R error(ResponseStatus status) {
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
        return JSONUtil.toJSONString(this);
    }

    public Object getData() {
        return data;
    }

    public R setData(Object data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public R setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public R setMessage(String message) {
        this.message = message;
        return this;
    }
}
