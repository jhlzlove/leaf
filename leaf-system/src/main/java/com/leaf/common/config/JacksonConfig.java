package com.leaf.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.leaf.util.LocalDateUtil;
import org.babyfish.jimmer.jackson.ImmutableModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 此类并未启用，当时写在这里是为了排查一些问题，于是就留下了
 *
 * @author jhlz
 * @version x.x.x
 * @since 2024/3/23 13:09
 */
// @Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            JavaTimeModule module = new JavaTimeModule();
            DateTimeFormatter dateTimeFormatter = LocalDateUtil.ofPattern(LocalDateUtil.DATE_TIME_PATTERN);
            DateTimeFormatter dateFormatter = LocalDateUtil.ofPattern(LocalDateUtil.DATE_PATTERN);
            module.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
            // 注册 module
            builder.modules(module, new ImmutableModule());
            // 忽略未知字段
            builder.featuresToEnable(JsonGenerator.Feature.IGNORE_UNKNOWN);
        };
    }


    /**
     * 标记为主ObjectMapper，确保其他依赖此bean的地方都使用这个配置过的ObjectMapper
     *
     * @param builder 自定义的 Jackson2ObjectMapperBuilder
     * @return 自定义的 ObjectMapper
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        return builder.build();
    }
}
