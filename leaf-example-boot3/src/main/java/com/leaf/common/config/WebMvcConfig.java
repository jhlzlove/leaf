package com.leaf.common.config;

import com.leaf.common.interceptor.CustomerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web 配置
 *
 * @author jhlz
 * @since 2022/8/10 16:26
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

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
                .allowCredentials(false)
                // 所有头
                .allowedHeaders("/**")
                // 所有源
                .allowedOrigins("/**")
                // 所有方法
                .allowedMethods("/**")
                .maxAge(3600);
    }

}
