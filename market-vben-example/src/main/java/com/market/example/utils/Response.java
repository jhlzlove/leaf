package com.market.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author clf
 * @time 2022/8/10 14:52
 * @desc: Response：返回结果集
 */
public class Response {
    /**
     * code
     **/
    private String code;

    /**
     * 返回数据
     **/
    private Object data;

    /**
     * 描述信息
     **/
    private String desc;

    public Response() {
    }

    public Response(String code, Object data, String desc) {
        this.code = code;
        this.data = data;
        this.desc = desc;
    }

    public static Response success(String code, Object data, String desc) {
        return new Response(code, data, desc);
    }

    /**
     * 成功
     */
    public static Response success(Object data) {
        return success("200", data, "操作成功");
    }

    public static Response success(String message) {
        return success("200", null, message);
    }

    public static Response success() {
        return success(null);
    }

    /**
     * 失败
     */
    public static Response error(String code, String message) {
        Response rb = new Response();
        rb.setCode(code);
        rb.setDesc(message);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static Response error(String message) {
        Response rb = new Response();
        rb.setCode("-100");
        rb.setDesc(message);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
