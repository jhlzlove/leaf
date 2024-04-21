package com.leaf.service.impl;

import com.leaf.constant.LeafConstants;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserDraft;
import com.leaf.response.Response;
import com.leaf.service.LeafUserService;
import com.leaf.service.LoginService;
import com.leaf.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Service
@Transactional("tm1")
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final LeafUserService userService;

    public LoginServiceImpl(AuthenticationManager authenticationManager,
                            UserDetailsService userDetailsService,
                            LeafUserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    @Transactional("tm1")
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

    @Override
    @Transactional("tm1")
    public Response register(LeafUser user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(user.password());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String nickName = user.nickName() == null ? LeafConstants.LEAF + uuid : user.nickName();
        LeafUser leafUser = LeafUserDraft.$.produce(draft -> {
                    draft.setUsername(user.username());
                    draft.setPassword(encodePassword);
                    draft.setNickName(nickName);
                }
        );
        LeafUser result = userService.save(leafUser);
        return ObjectUtils.isEmpty(result) ? Response.error() : Response.ok();
    }

}
