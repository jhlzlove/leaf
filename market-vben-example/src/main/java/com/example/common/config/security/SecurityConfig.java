package com.example.common.config.security;

import com.example.common.filter.JwtAuthenticationTokenFilter;
import com.example.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author clf
 * @time 2022/8/10 11:26
 * @desc: Spring Security Config
 * 在 Spring Security 5.7 版本中 WebSecurityConfigurerAdapter 已经废弃，新版的使用方式以配置 Chain 为主
 */
@Configuration
// 添加 security 过滤器
@EnableWebSecurity
// 启用方法级别的权限认证
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    /**
     * 暴露AuthenticationManager（认证管理器），登录时认证使用
     *
     * @param authenticationConfiguration
     * @return
     * @throws Exception
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
     * mvcMatchers、antMatchers 没有太大区别，可以看源码注释
     * 由于 antMatchers 出现的比 mvcMatchers 早，这里混用，了解一下。
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 前后端分离项目，跨站请求伪造不生效，关闭
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests(authorize -> {
                    authorize
                            // 匿名访问（在登录状态下不可访问）
                            .mvcMatchers(
                                    "/api/system/login",
                                    "/system/login"
                            ).anonymous()
                            // 开放 api
                            .mvcMatchers(
                                    "/api/system/**",
                                    "/file/**",
                                    "/doc.html",
                                    "/swagger**/**",
                                    "/webjars/**",
                                    "/v3/**"
                            ).permitAll()
                            // 除上面以外的所有请求都需要认证
                            .anyRequest().authenticated();
                })
                // 添加 jwt 过滤器在 UsernamePasswordAuthenticationFilter 之前
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 设置自定义认证数据源
                .userDetailsService(loginService)
                // 配置 CORS 跨域访问
                .cors().configurationSource(corsConfigurationSource());
        return http.build();
    }

    /**
     * 配置跨源访问(CORS)
     *
     * @return
     */
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    private final LoginService loginService;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    public SecurityConfig(LoginService loginService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.loginService = loginService;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }
}
