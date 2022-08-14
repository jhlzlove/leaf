package com.market.example.security;

import com.market.example.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author clf
 * @time 2022/8/10 11:26
 * @desc: Spring Security Config
 * 在新的 Spring Security 版本中 WebSecurityConfigurerAdapter 已经废弃，使用方式和之前不同
 */
@Configuration
@EnableWebSecurity    // 添加 security 过滤器
// @EnableGlobalMethodSecurity(prePostEnabled = true)    // 启用方法级别的权限认证
public class SecurityConfig {

    @Autowired
    private UserDetailServiceImpl userDetailService;

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
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests(authorize -> {
                    authorize
                            // 允许匿名用户访问
                            .antMatchers("/user/login",
                                    "/doc.html",
                                    "/swagger**/**",
                                    "/webjars/**",
                                    "/v3/**").anonymous()
                            // 开放api
                            .antMatchers("/api/**")
                            .permitAll()
                            // 除上面以外的所有接口都需要认证
                            .anyRequest().authenticated();
                })
                // 设置自定义认证数据源
                .userDetailsService(userDetailService)
                // 配置 CORS 跨域访问
                .cors().configurationSource(corsConfigurationSource());
        return http.build();
    }

    /**
     * 密码加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
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

}
