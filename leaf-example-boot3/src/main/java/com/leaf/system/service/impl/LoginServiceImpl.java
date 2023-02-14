package com.leaf.system.service.impl;

import com.leaf.common.utils.JwtUtil;
import com.leaf.system.domain.LoginUser;
import com.leaf.system.domain.User;
import com.leaf.system.repository.UserRepository;
import com.leaf.system.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 登录接口实现
 *
 * @author jhlz
 * @since 2022/12/20 21:32
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(User user) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        Optional.ofNullable(authenticate)
                .orElseThrow(() -> new UsernameNotFoundException("Not found user"));
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long id = loginUser.getUser().getId();
        String token = JwtUtil.createToken(id.toString());
        log.info(" token {}", token);
        return token;
    }

    @Override
    public void logout() {

    }

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public LoginServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

}
