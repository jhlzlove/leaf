package com.example.common.response;

import lombok.Data;

import java.util.Optional;

/**
 * 返回结果简单封装
 *
 * @author jhlz
 * @since 2022/10/3 16:19:42
 */
@Data
public class RespResult {
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

    public RespResult() {
    }

    /**
     * 默认成功处理
     *
     * @return
     */
    public static RespResult success() {
        return success(RespStatus.SUCCESS);
    }

    public static RespResult success(RespStatus status) {
        return success(status.getCode(), success().getMessage());
    }

    public static RespResult success(int code, String message) {
        return success(code, message, null);
    }

    public static RespResult success(Object data) {
        RespResult resp = success(RespStatus.SUCCESS.getCode(), RespStatus.SUCCESS.getMessage(), data);
        return resp;
    }

    public static RespResult success(int code, String message, Object data) {
        RespResult resp = new RespResult();
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
    public static RespResult error() {
        return error(RespStatus.ERROR);
    }

    public static RespResult error(RespStatus status) {
        return error(status.getCode(), status.getMessage());
    }

    public static RespResult error(int code, String message) {
        RespResult resp = new RespResult();
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }
}
