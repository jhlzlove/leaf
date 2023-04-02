package com.leaf.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 项目自定义配置选项
 * 奇怪哦，什么时候可以使用 record 哦
 *
 * @author jhlz
 * @since 2023/3/4 15:27
 */
@Component
public class LeafProperties {
    /**
     * 认证头标识 默认 Authorization，可以改为 token 以及其它自己喜欢的标识
     * 重要的是前后端统一 ^~^
     */
    @Value("${leaf.header}")
    private String header;

    @Value("${leaf.version}")
    private String version;

    @Value("${leaf.api-prefix}")
    private String apiPrefix;

    public String getHeader() {
        return StringUtils.hasText(header) ? header : "Authorizaton";
    }

    public String getVersion() {
        return version;
    }

    public String getApiPrefix() {
        return apiPrefix;
    }
}
