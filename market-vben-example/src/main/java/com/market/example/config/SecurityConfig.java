package com.market.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetails(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.builder().username("jhlz").password("{noop}root").authorities("admin").build());
        return manager;
    }

    /**
     * anonymous | 只允许匿名访问（未登录用户）
     * permitAll | 允许所有用户访问
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().formLogin().and()
                .authorizeRequests(authorize -> {
                    // 允许匿名用户访问
                    authorize.antMatchers("/hello", "/register",
                                    "/doc.html",
                                    "/swagger**/**",
                                    "/webjars/**",
                                    "/v3/**")
                            .anonymous()
                            // 除上面以外的所有接口都需要认证
                            .anyRequest().authenticated();
                }).userDetailsService(userDetails()).build();
    }

    /**
     * 配置跨源访问(CORS)
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
