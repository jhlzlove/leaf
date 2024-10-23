package com.leaf.framework;

import io.smallrye.jwt.build.Jwt;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * @author jhlz
 */
public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * example:
     **/
    @Test
    public void jwt_Test() {
        String sign = Jwt.issuer("jhlz").claim("name", "jhlz").claim("age", 20)
                .expiresAt(30000)
                .groups(Collections.singleton("test:user"))
                .signWithSecret("secret");
        System.out.println(sign);
    }
}
