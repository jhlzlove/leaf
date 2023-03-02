package com.leaf.common.filter;

import com.leaf.common.exception.BusinessException;
import com.leaf.common.exception.GlobalException;
import com.leaf.common.util.JwtUtil;
import com.leaf.system.entity.LeafUser;
import com.leaf.system.repository.LeafUserRepository;
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
import java.util.Objects;

/**
 * JwtAuthenticationTokenFilter Token 认证过滤器
 *
 * @author jhlz
 * @since 2022/8/13 18:55
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 获取 token
        String token = request.getHeader("token");
        // 2. 如果 token 为空，没有登录状态，放行不再执行后面的代码，进入其它过滤器链执行，可以重定向到登录地址
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. 否则，验证 token
        if (JwtUtil.verifyToken(token) && !JwtUtil.isExpired(token)) {
            // 4. 解析 token 信息获取用户信息（此处的 key 值取决于用户登录时生成 token 的方式）
            Long id = JwtUtil.getPayloadClaims(token, "uuid").asLong();
            if (Objects.nonNull(id)) {
                LeafUser user = userRepository.findById(id)
                        .orElseThrow(() -> new GlobalException(BusinessException.FAILED_AUTHORIZATION));

                // TODO 获取该用户的权限

                // 4. 此处必须使用三个参数（用户名，密码，角色）的构造方法，否则认证失败
                // 该方法可以按照 用户名，密码，角色 的顺序，也可以直接把用户放到第一个参数，其它两个参数为 null；
                // 如果有角色把第二个参数设为 null 即可
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, null);
                // 5. 把认证信息存入 SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        // 6. 放行
        filterChain.doFilter(request, response);
    }

    private final LeafUserRepository userRepository;

    public JwtAuthenticationTokenFilter(LeafUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
