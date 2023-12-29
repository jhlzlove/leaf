package com.leaf.common.filter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.leaf.common.util.SecurityUtil;
import com.leaf.constant.LeafConstants;
import com.leaf.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * JwtAuthenticationTokenFilter Token 认证过滤器
 *
 * @author jhlz
 * @since 2022/8/13 18:55
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationTokenFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (Objects.isNull(SecurityUtil.getAuthentication())) {
            String tokenHeader = request.getHeader(LeafConstants.AUTHORIZATION);
            if (Objects.nonNull(tokenHeader) && tokenHeader.startsWith(LeafConstants.BEARER_TOKEN)) {
                String token = tokenHeader.substring(7);
                request.setCharacterEncoding(StandardCharsets.UTF_8.name());
                tokenHandler(request, token);
            }
        }
        filterChain.doFilter(request, response);
    }

    private void tokenHandler(HttpServletRequest request, String token) {
        try {
            if (JwtUtil.verifyToken(token)) {
                String username = JwtUtil.getSubject(token);
                UserDetails user = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 认证信息存入 SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (AlgorithmMismatchException e) {
            request.setAttribute("description", "请求 token 使用的算法与本系统不匹配！");
            throw new AlgorithmMismatchException(e.getMessage());
        } catch (TokenExpiredException e) {
            request.setAttribute("description", "请求 token 已过期！请重新登录！");
            throw new TokenExpiredException(e.getMessage(), e.getExpiredOn());
        } catch (InvalidClaimException e) {
            request.setAttribute("description", "无效的 Claim！");
            throw new InvalidClaimException(e.getMessage());
        } catch (RuntimeException e) {
            request.setAttribute("description", "token 解析失败！");
            throw new JWTVerificationException(e.getMessage());
        }
    }

}
