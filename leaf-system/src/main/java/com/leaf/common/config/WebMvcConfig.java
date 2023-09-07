package com.leaf.common.config;

import com.leaf.common.interceptor.CustomerInterceptor;
import com.leaf.common.property.LeafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
     * 创建自定义拦截器交给 Spring 管理
     *
     * @return 自定义拦截器
     */
    @Bean
    public CustomerInterceptor customerInterceptor() {
        return new CustomerInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customerInterceptor());
    }

    /**
     * 跨域访问（CORS）
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
     * 给使用某个注解的 controller 层全部加上指定的前缀
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(leafProperties.getApiPrefix(), c -> c.isAnnotationPresent(RestController.class));
    }
}
