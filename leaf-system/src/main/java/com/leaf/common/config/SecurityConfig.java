package com.leaf.common.config;

import com.leaf.common.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
@EnableMethodSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    /**
     * 暴露AuthenticationManager（认证管理器）
     *
     * @return AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Security 5.7 Spring Boot Security 2.7 之后新的写法
     * 等同于 WebSecurityConfigurerAdapter#configure(HttpSecurity http)
     * anonymous | 只允许匿名访问（未登录用户）
     * permitAll | 允许所有用户访问
     * mvcMatchers、antMatchers 没有太大区别，可以看源码注释，boot3 推荐使用新版 mvcMatchers
     *
     * @param http http
     * @return SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 关闭 csrf
                .csrf(AbstractHttpConfigurer::disable)
                // 不需要 session
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((request) -> {
                    request.requestMatchers("/login", "/api/login").anonymous()
                            .requestMatchers("/v3/api-docs**").permitAll()
                            .requestMatchers("/register", "/api/register", "/open/**").permitAll()
                            .anyRequest().authenticated();
                })
                // 第一次面试都没过去，就不要浪费时间了！呜呜呜，像极了我的面试
                // 添加 jwt 过滤器在 UsernamePasswordAuthenticationFilter 之前
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 设置自定义认证数据源
                .userDetailsService(userDetailsService)
                // 退出 https://docs.spring.io/spring-security/reference/servlet/authentication/logout.html
                .logout(logout -> logout.logoutUrl("/logout").permitAll())
                .build();
    }

}
