package com.leaf.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jhlz
 * @version x.x.x
 */
public class SecurityTest {

    /**
     * test: passwordEncoder_SpringSecurity example
     */
    @Test
    public void passwordEncoder_SpringSecurityTest() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    }
}
