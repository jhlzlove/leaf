package com.leaf.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author jhlz
 */
public class JwtTest {

    /**
     * test: jwt example
     */
    @Test
    public void jwt_generator_Test() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        Assertions.assertTrue(passwordEncoder.matches("123456", encode));
        System.out.println(encode);
        // String token1 = JwtUtil.createToken(Map.of("payload", "jhlz"), "jhlz");
        // System.out.println(token1);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJqaGx6IiwiZXhwIjoxNjk2NDk4NjA0LCJwYXlsb2FkIjoxfQ.8Aw8K9GoSSwLcuBFP7WI6YZY7KCa6XH8HaamkC-E0b4";
        // Assertions.assertTrue(JwtUtil.verifyToken(token));
    }
}
