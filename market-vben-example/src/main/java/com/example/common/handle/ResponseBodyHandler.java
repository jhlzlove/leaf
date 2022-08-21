package com.example.common.handle;

import com.example.common.exception.ResultStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object result = new ResponseResult<>(body, ResultStatus.Common.SUCCESS.getRetcode(), ResultStatus.Common.SUCCESS.getMsg(), null, null);
        if (body instanceof String) {
            // 如果原始的返回body是json字符串，则设置返回内容的类型
            try {
                result = new ObjectMapper().writeValueAsString(result);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        }
        return result;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.getParameterType().isAssignableFrom(ResponseResult.class)
                || returnType.getParameterType().isAssignableFrom(ResponseEntity.class)
                || returnType.hasMethodAnnotation(NotWrapResponse.class)) {
            return false;
        }
        return true;
    }

}
