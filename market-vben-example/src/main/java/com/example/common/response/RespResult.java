package com.example.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果简单封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespResult {
    /**
     * 结果对象
     **/
    private Object result;

    /**
     * 状态码
     **/
    private int code;

    /**
     * 信息
     **/
    private String message;

    /**
     * 错误说明
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;

    /**
     * 请求id
     **/
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String traceId;

}
