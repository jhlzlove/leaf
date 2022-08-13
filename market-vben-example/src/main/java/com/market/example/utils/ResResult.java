package com.market.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.example.constant.RequestEnum;
import org.springframework.util.ObjectUtils;

/**
 * @author clf
 * @time 2022/8/10 14:52
 * @desc: Response：返回结果
 */
public class ResResult {

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
    private String message;

    /**
     * 默认成功的方法
     *
     * @return
     */
    public static ResResult success() {
        return success(null, RequestEnum.SUCCESS.getMessage());
    }


    public static ResResult success(Object data) {
        return success(data, RequestEnum.SUCCESS.getMessage());
    }

    public static ResResult success(String message) {
        return success(null, message);
    }

    /**
     * 成功
     *
     * @param data    数据
     * @param message 消息描述
     * @return ResResult 消息体
     */
    public static ResResult success(Object data, String message) {
        ResResult resResult = new ResResult();
        if (!ObjectUtils.isEmpty(message)) {
            resResult.setMessage(message);
        }
        if (!ObjectUtils.isEmpty(data)) {
            resResult.setData(data);
        }
        resResult.setCode(RequestEnum.SUCCESS.getCode());
        return resResult;
    }

    /**
     * 失败
     *
     * @return
     */
    public static ResResult error() {
        ResResult resResult = new ResResult();
        resResult.setCode(RequestEnum.ERROR.getCode());
        resResult.setMessage(RequestEnum.ERROR.getMessage());
        return resResult;
    }

    public static ResResult error(String message) {
        ResResult resResult = new ResResult();
        resResult.setCode("400");
        resResult.setMessage(message);
        return resResult;
    }

    public ResResult() {
    }

    public ResResult(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writer().writeValueAsString(this);
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
