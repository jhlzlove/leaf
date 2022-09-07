package com.example.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jhlz
 * @time 2022/9/1 13:29
 * @desc: CustomerProperties 自定义配置
 */
@Component
@ConfigurationProperties
@Data
public class CustomerProperties {

    /**
     * 全局统一路径
     */
    @Value("${api.path.global-prefix}")
    private String globalPrefix = "api";

    /**
     * token 标头
     */
    @Value("${token.prefix} ")
    private String TOKEN_PREFIX = "Authorization ";
}
