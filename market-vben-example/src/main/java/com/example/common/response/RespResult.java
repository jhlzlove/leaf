package com.example.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespResult {
    /**
     * 请求结果对象
     **/
    private Object data;

    /**
     * 请求结果的状态码
     **/
    private int code;

    /**
     * 错误消息
     **/
    private String message;

    /**
     * 错误详细
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;

    /**
     * 请求id
     **/
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String traceId;

}
