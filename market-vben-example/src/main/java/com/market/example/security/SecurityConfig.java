package com.market.example.security;

import com.market.example.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author clf
 * @time 2022/8/10 11:26
 * @desc: Spring Security Config
 * 在新的 Spring Security 版本中 WebSecurityConfigurerAdapter 已经废弃，使用方式和之前不同
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailServiceImpl userDetailService;

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
        http.csrf().disable().formLogin().and()
                .authorizeRequests(authorize -> {
                    // 允许匿名用户访问
                    authorize.antMatchers("/hello", "/register", "/login", "/get/**",
                                    "/doc.html",
                                    "/swagger**/**",
                                    "/webjars/**",
                                    "/v3/**")
                            .anonymous()
                            // 除上面以外的所有接口都需要认证
                            .anyRequest().authenticated();
                })
                // 设置自定义认证数据源
                .userDetailsService(userDetailService);
        return http.build();
    }

    /**
     * 等同于 WebSecurityConfigurerAdapter#configure(WebSecurity web)
     *
     * @return
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }
}
