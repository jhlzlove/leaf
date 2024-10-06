package com.leaf.property;

import org.eclipse.microprofile.config.inject.ConfigProperties;

/**
 * 项目自定义配置选项
 * 奇怪哦，什么时候可以使用 record 哦
 * 不过确实，Record 类已经足够简单明了，不需要使用额外的注解进行辅助描述。
 *
 * @author jhlz
 * @version 1.0.0
 */
public class LeafProperties {

    /**
     * 系统版本
     */
    @ConfigProperties(prefix = "leaf.version")
    private String version;

    /**
     * 统一访问前缀
     */
    @ConfigProperties(prefix = "${leaf.api-prefix}")
    private String apiPrefix;

    public String getVersion() {
        return version;
    }

    public String getApiPrefix() {
        return apiPrefix;
    }
}
