package com.example.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig开启 EnableWebMvc注解，
 * 否则会报错：Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException: Cannot invoke "org.springframework.web.servlet.mvc.condition.PatternsRequestCondition.getPatterns()" because "this.condition" is null
 *
 * @author jhlz
 * @since 2022/8/10 16:26
 */
@Component
@EnableWebMvc
@EnableOpenApi
public class SwaggerConfig {

    /**
     * swagger 没有配置前端 ui，所以访问 http://localhost:port/doc.html 无效
     * 需要的可以自己添加喜欢的依赖，例如 swagger-ui、knife 等
     * 3.0 默认文档访问 http://localhost:port/swagger-ui/index,html，使用 Apifox 输入此地址导入接口
     *
     * @return
     */
    @Bean
    public Docket docket() {
        // 使用 swagger 3.0
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("全新版本的系统")
                                .description("")
                                .version("v0.1")
                                .termsOfServiceUrl("https://prettywinter.github.io")
                                .license("MIT")
                                .licenseUrl("https://choosealicense.com/licenses/mit/")
                                .contact(new Contact("jhlz", "https://jhlzlove.github.io", "jhlzlove@163.com"))
                                .build()
                )
                .enable(true)
                .select()
                // 扫描指定目录的所有接口
                // .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                // 扫描指定注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/**"))
                .build();
    }

}
