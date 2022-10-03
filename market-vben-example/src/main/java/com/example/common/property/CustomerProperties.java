package com.example.common.property;

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
    @Value("${api.path.global-prefix:'api'}")
    private String globalPrefix;

    /**
     * token 标头
     * 如果配置文件中没有此配置，默认值为 Authorization
     */
    @Value("${token.prefix:Authorization} ")
    private String TOKEN_PREFIX;
}
