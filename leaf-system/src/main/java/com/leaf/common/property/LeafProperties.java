package com.leaf.common.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 项目自定义配置选项
 * 奇怪哦，什么时候可以使用 record 哦
 * 不过确实，Record 类已经足够简单明了，不需要使用额外的注解进行辅助描述。
 *
 * @author jhlz
 * @since 2023/3/4 15:27
 */
@Component
public class LeafProperties {

    /**
     * 系统版本
     */
    @Value("${leaf.version}")
    private String version;

    /**
     * 统一访问前缀
     */
    @Value("${leaf.api-prefix}")
    private String apiPrefix;

    public String getVersion() {
        return version;
    }

    public String getApiPrefix() {
        return apiPrefix;
    }
}
