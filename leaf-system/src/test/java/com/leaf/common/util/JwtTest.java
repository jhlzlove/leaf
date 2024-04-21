package com.leaf.common.util;

import com.leaf.util.JwtUtil;
import org.junit.jupiter.api.Test;

/**
 * @author jhlz
 * @version x.x.x
 * @since 2024/4/18 11:55
 */
public class JwtTest {

    /**
     * Test Example:
     */
    @Test
    public void jwtTest() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTM0MTQ4NjMsInBhc3N3b3JkIjoiMTIzIiwidXNlcm5hbWUiOiJhZG1pbiJ9.DjIaUujC4Owk-UvlKtYnUN756yw2DY1s0Quy1D-NIwE";
        System.out.println(JwtUtil.verifyToken(token));
    }
}
