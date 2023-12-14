package com.leaf.system.service.impl;

import code.leaf.constant.LeafConstants;
import code.leaf.response.Response;
import code.leaf.util.JwtUtil;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.domain.record.LoginUserRecord;
import com.leaf.system.service.LeafUserService;
import com.leaf.system.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jhlz
 * @version 1.0.0
 * @since 2023/10/3 16:11
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final LeafUserService userService;

    public LoginServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, LeafUserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    public Response login(LoginUserRecord user) {

        Authentication authenticate = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(user.username(), user.password())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.username());
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        // 4. 生成 token 返回
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put(LeafConstants.JWT_PAYLOAD, userDetails.getUsername());
        String token = JwtUtil.createToken(payload, userDetails.getUsername());
        log.info("login success! userId: {}，username: {}",
                JwtUtil.getPayloadClaims(token, LeafConstants.JWT_PAYLOAD),
                JwtUtil.getSubject(token));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(LeafConstants.TOKEN, token);
        map.put(LeafConstants.EXPIRED, JwtUtil.getExpiresAtAsInstant(token));
        // cache
        // Redis.cache(LeafConstants.LOGIN_REDIS_KEY + u.getUsername(), JSON.toJSONString(u), LeafConstants.LOGIN_REDIS_EXPIRED, TimeUnit.MINUTES);
        return Response.ok(map);
    }

    @Override
    public Response register(LoginUserRecord user) {
        LeafUser leafUser = new LeafUser();
        leafUser.setUsername(user.username());
        // leafUser.setPassword(passwordEncoder.encode(user.password()));
        leafUser.setStatus(0);
        leafUser.setDelFlag(0);
        return Response.ok(userService.save(leafUser));
    }

}
