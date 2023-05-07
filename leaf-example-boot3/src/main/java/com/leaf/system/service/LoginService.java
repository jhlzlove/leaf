package com.leaf.system.service;

import com.leaf.system.domain.LeafUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jhlz
 * @version 1.0.0
 * @since 2023/5/7 14:55
 */
@Service
public class LoginService implements UserDetailsService {
    public String login(LeafUser user) {
        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
