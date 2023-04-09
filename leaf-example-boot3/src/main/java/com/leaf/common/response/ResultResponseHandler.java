package com.leaf.common.response;

import com.leaf.common.annotation.NotWrapResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Controller 接口层返回数据统一处理
 * 注意：使用其它接口工具导入 swagger 接口进行自动化或者批量测试时，不以该对象为主，而是以 controller 中实际返回的对象为主。
 * 这样会造成使用的工具数据校验失败，可以选择关闭工具的返回结果校验或者 controller 的每个方法的返回值都为封装的对象
 */
@RestControllerAdvice("*.*.*.controller")
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            return body;
        }
        return Response.success(body);
    }

    /**
     * execute beforeBodyWrite ? true : false
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, @NonNull Class converterType) {
        return !returnType.getParameterType().isAssignableFrom(Response.class)
                && !returnType.getParameterType().isAssignableFrom(ResponseEntity.class)
                && !returnType.hasMethodAnnotation(NotWrapResponse.class);
    }

}
