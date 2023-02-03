package com.leaves.common.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.leaves.common.exception.BusinessException;
import com.leaves.common.exception.GlobalException;
import com.leaves.common.utils.JwtUtil;
import com.leaves.system.domain.User;
import com.leaves.system.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JwtAuthenticationTokenFilter Token认证过滤器
 *
 * @author jhlz
 * @since 2022/8/13 18:55
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取 token
        String token = request.getHeader("token");
        // 如果 token 为空，放行，进入其它过滤器链执行
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 否则，解析 token
        DecodedJWT decodedJWT = JwtUtil.getDecodedJWT(token);
        String subject = decodedJWT.getSubject();
        // 获取用户
        if (!StringUtils.hasText(subject)) {
            User user = userRepository.findById(Long.parseLong(subject))
                    .orElseThrow(() -> new GlobalException(BusinessException.FAILED_AUTHORIZATION));

            // TODO 获取该用户的权限

            // 此处必须使用 三个参数 的构造方法，否则认证败
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, null);
            // 存入 SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // 放行
        filterChain.doFilter(request, response);
    }

    private final UserRepository userRepository;

    public JwtAuthenticationTokenFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
