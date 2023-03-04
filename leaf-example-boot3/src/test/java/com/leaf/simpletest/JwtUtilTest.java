package com.leaf.simpletest;

import com.leaf.common.util.JwtUtil;
import org.eclipse.collections.api.factory.Maps;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * JwtUtil test
 *
 * @author jhlz
 * @since 2023/3/1 10:10
 */
public class JwtUtilTest {

    private static final Logger log = LoggerFactory.getLogger(JwtUtilTest.class);

    /**
     * test: createToken example
     */
    @Test
    public void createTokenTest() {
        Map<String, Object> payload = Maps.mutable.empty();
        HashMap<String, Object> headers = new HashMap<>();
        payload.put("name", "江湖浪子");
        payload.put("token", 123);
        headers.put("name", "江枫");

        JwtUtil.createToken(payload);

    }
}
