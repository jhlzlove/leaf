package com.example.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author clf
 * @time 2022/8/10 16:26
 * @desc: SwaggerConfig
 * 开启 EnableWebMvc注解，
 * 否则会报错：Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException: Cannot invoke "org.springframework.web.servlet.mvc.condition.PatternsRequestCondition.getPatterns()" because "this.condition" is null
 */
@Component
@EnableWebMvc
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        // 使用 seagger 3.0
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("jhlz")
                .select()
                // 扫描指定目录的所有接口
                // .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                // 扫描指定注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("全新版本的系统", "",
                "v0.1", "https://prettywinter.github.io",
                "jhlz",
                "MIT", "https://choosealicense.com/licenses/mit/");
    }

}
