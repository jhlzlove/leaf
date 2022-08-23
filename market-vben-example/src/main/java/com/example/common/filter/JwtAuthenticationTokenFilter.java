package com.example.common.filter;

import com.example.common.constant.GlobalConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author clf
 * @time 2022/8/13 18:55
 * @desc: JwtAuthenticationTokenFilter Token认证过滤器
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 获取并解析 token
        String token = request.getHeader("token");
        if (!ObjectUtils.isEmpty(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        Claims body = Jwts.parser().setSigningKey(GlobalConstants.JWT_KEY)
                .parseClaimsJws(token).getBody();
        logger.info("Parse Claims：{}", body.toString());
    }


}
