package com.example.common.response;

import com.example.common.annotation.NotWrapResponse;
import com.example.common.utils.JSONUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一对 Controller 层返回的结果做包装
 */
@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object result = new RespResult(body, RespStatus.Common.SUCCESS.getCode(),
                RespStatus.Common.SUCCESS.getMessage(), null, null);
        if (body instanceof String) {
            // 如果原始的返回body是json字符串，则设置返回内容的类型
            result = JSONUtil.toJSON(request);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        }
        return result;
    }

    /**
     * execute beforeBodyWrite ? true : false
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.getParameterType().isAssignableFrom(RespResult.class)
                || returnType.getParameterType().isAssignableFrom(ResponseEntity.class)
                || returnType.hasMethodAnnotation(NotWrapResponse.class)) {
            return false;
        }
        return true;
    }

}
