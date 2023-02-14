package com.leaf.common.response;

import com.leaf.common.utils.JSONUtil;

import java.io.Serializable;
import java.util.Optional;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @since 2022/10/3 16:19:42
 */
public class ResultResponse implements Serializable {
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

    public ResultResponse() {
    }

    /**
     * 默认成功处理
     *
     * @return
     */
    public static ResultResponse success() {
        return success(ResultEnum.SUCCESS);
    }

    public static ResultResponse success(ResultEnum status) {
        return success(status.getCode(), success().getMessage());
    }

    public static ResultResponse success(int code, String message) {
        return success(code, message, null);
    }

    public static ResultResponse success(Object data) {
        ResultResponse resp = success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
        return resp;
    }

    public static ResultResponse success(int code, String message, Object data) {
        ResultResponse resp = new ResultResponse();
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
    public static ResultResponse error() {
        return error(ResultEnum.ERROR);
    }

    public static ResultResponse error(ResultEnum status) {
        return error(status.getCode(), status.getMessage());
    }

    public static ResultResponse error(int code, String message) {
        ResultResponse resp = new ResultResponse();
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

    public ResultResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
