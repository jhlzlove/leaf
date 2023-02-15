package com.leaf.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.leaf.common.interceptor.CustomerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        registry.addInterceptor(customerInterceptor())
                .excludePathPatterns(
                        "/openapi/**",
                        "/file/**",
                        "/doc.html",
                        "/swagger**/**",
                        "/webjars/**",
                        "/v3/**");
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

    @Bean
    public ObjectMapper serializingObjectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        // 这里导包的时候选择自己定义的LocalDateTimeDeserializer
        LocalDateTimeDeserializer dateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        module.addDeserializer(LocalDateTime.class, dateTimeDeserializer);
        return Jackson2ObjectMapperBuilder.json().modules(module)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();
    }

    /**
     * ObjectMapper 序列化配置
     *
     * @param converters initially an empty list of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        JavaTimeModule module = new JavaTimeModule();
        // 序列化器
        module.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 反序列化器
        // 这里添加的是自定义的反序列化器
        module.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        // jackson 序列化时，不对无效字段（null）检查
        // 举个栗子，遇到过使用 @RequestBody 注解的对象当前端传不全时，控制台打印 not found mapping，xxx property is null...
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // add converter at the very front
        // if there are same type mappers in converters, setting in first mapper is used.
        converters.add(0, new MappingJackson2HttpMessageConverter(mapper));
    }

}