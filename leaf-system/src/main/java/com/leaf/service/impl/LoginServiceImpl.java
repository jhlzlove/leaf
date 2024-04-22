package com.leaf.service.impl;

import com.leaf.common.response.Response;
import com.leaf.constant.LeafConstants;
import com.leaf.domain.LeafUser;
import com.leaf.service.LoginService;
import com.leaf.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public LoginServiceImpl(AuthenticationManager authenticationManager,
                            UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Response login(LeafUser user) {
        Authentication authenticate = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(user.username(), user.password())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.username());
        // 生成 token 返回
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("username", userDetails.getUsername());
        String token = JwtUtil.createToken(payload);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(LeafConstants.TOKEN, token);
        map.put(LeafConstants.EXPIRED, JwtUtil.getExpiresAtAsInstant(token));
        return Response.ok(map);
    }

}
