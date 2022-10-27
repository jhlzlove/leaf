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
 * Controller 接口返回数据统一处理
 */
@RestControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return JSONUtil.toJSON(body);
        }
        return RespResult.success(body);
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
