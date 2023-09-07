package com.leaf.common.filter;

import com.leaf.common.constant.LeafConstants;
import com.leaf.common.exception.BusinessException;
import com.leaf.common.exception.GlobalException;
import com.leaf.common.property.LeafProperties;
import com.leaf.common.util.JwtUtil;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.repository.LeafUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        // 1. 获取 token 头
        String tokenHeader = request.getHeader(leafProperties.getHeader());
        // 2. 不为空进行下一步验证
        if (StringUtils.hasText(tokenHeader)) {
            String token = getToken(tokenHeader);
            // 3. 有效期内喝完体验更好哦，哦，不对，验证 token 以及是否过期
            if (JwtUtil.verifyToken(token) && !JwtUtil.isExpired(token)) {
                // 4. 解析 token 信息获取用户信息（此处的 key 值为自定义的值）
                String username =
                        JwtUtil.getPayloadClaims(token, LeafConstants.LOGIN_JWT_NAME_KEY).asString();
                if (StringUtils.hasText(username)) {
                    LeafUser user = userRepository.findByUsername(username);
                    if (Objects.isNull(user)) {
                        throw new GlobalException(BusinessException.FAILED_AUTHORIZATION);
                    }

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
        }
        // 6. 其它情况都是非法偷渡的，不过我们很大度，放它们走吧。须知，天网恢恢，疏而不失。
        // 放行，进入其它过滤器链执行对应的逻辑
        filterChain.doFilter(request, response);
    }

    /**
     * token 处理
     *
     * @param token 请求头获取的 token
     * @return 处理后的 token
     */
    private static String getToken(final String token) {
        return token.startsWith(LeafConstants.TOKEN_PREFIX_KEY) ?
                token.replace(LeafConstants.TOKEN_PREFIX_KEY, "") : token;
    }

    private final LeafUserRepository userRepository;
    private final LeafProperties leafProperties;

    public JwtAuthenticationTokenFilter(LeafUserRepository userRepository,
                                        LeafProperties leafProperties) {
        this.userRepository = userRepository;
        this.leafProperties = leafProperties;
    }
}
