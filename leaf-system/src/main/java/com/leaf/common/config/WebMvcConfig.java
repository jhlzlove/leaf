package com.leaf.common.config;

import com.leaf.common.property.LeafProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web 配置
 *
 * @author jhlz
 * @since 2022/8/10 16:26
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final LeafProperties leafProperties;

    public WebMvcConfig(LeafProperties leafProperties) {
        this.leafProperties = leafProperties;
    }

    /**
     * MVC 跨域访问配置（CORS）
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(3600L);
    }

    /**
     * 为 controller 使用指定注解的请求全部加上指定的前缀
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(leafProperties.getApiPrefix(), c -> c.isAnnotationPresent(RestController.class));
    }
}
