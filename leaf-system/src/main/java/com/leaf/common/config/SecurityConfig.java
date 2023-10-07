package com.leaf.common.config;

import com.leaf.common.filter.JwtAuthenticationTokenFilter;
import com.leaf.common.response.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Spring Security Config
 * 在 Spring Security 5.7 版本中 WebSecurityConfigurerAdapter 已经废弃，新版的使用方式以配置 Chain 为主
 *
 * @author jhlz
 * @since 2022/8/10 11:26
 */
@Configuration
// 添加 security 过滤器
@EnableWebSecurity
// 启用方法级别的权限认证
// @EnableMethodSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    /**
     * 创建 AuthenticationManager（认证管理器）交由 Spring 管理，可以注入使用，例如登录接口
     *
     * @return AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Security 6.x、Spring Boot Security 2.7 之后新的写法: Lambda 表达式不再使用 and()
     * 等同于 WebSecurityConfigurerAdapter#configure(HttpSecurity http)
     *
     * @param http http
     * @return SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 关闭 csrf
                .csrf(AbstractHttpConfigurer::disable)
                // 不创建 session
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 以 api 开头的请求规则
                .authorizeHttpRequests(
                        (auth) -> {
                            // PathRequest.toStaticResources().atCommonLocations()
                            auth.requestMatchers("/api/login").anonymous()
                                    .requestMatchers("/api/v3/**", "/api/register").permitAll()
                                    .anyRequest().authenticated();
                        })
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 设置自定义认证数据源
                .userDetailsService(userDetailsService)
                // 认证和权限不足处理，这里简单返回
                // 一般自己实现 AuthenticationEntryPoint、AccessDeniedHandler 两个接口然后注册到 security 中
                .exceptionHandling(
                        e -> e.authenticationEntryPoint(((request, response, exception) -> {
                            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                            String message = "用户认证异常：" + request.getAttribute("description");
                            Response error =
                                    Response.error(HttpStatus.UNAUTHORIZED.value(), message, exception.getMessage());
                            response.getWriter().write(error.toString());
                        }))
                )
                .build();
    }

    /**
     * Spring Security 跨域配置
     *
     * @return CorsConfigurationSource
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); // 设置允许访问的来源
        configuration.setAllowedMethods(List.of("*")); // 设置允许的方法
        configuration.setAllowedHeaders(List.of("*")); // 设置允许的头
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
