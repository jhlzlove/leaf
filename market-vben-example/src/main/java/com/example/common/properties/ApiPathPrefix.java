package com.example.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jhlz
 * @time 2022/9/1 13:29
 * @desc: ApiPathProperties
 * 请求前缀地址，默认前缀 api
 */
@Component
@ConfigurationProperties(prefix = "api.path")
@Data
public class ApiPathPrefix {

    private String globalPrefix = "api";
}
