package com.example.simpletest;

import com.example.common.utils.HttpUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: jhlz
 * @since: 2022/12/14 20:41:36
 */
public class HttpUtilTest {

    private static final Logger log = LoggerFactory.getLogger(HttpUtilTest.class);

    /**
     * test: httputil example
     */
    @Test
    public void testHttpUtil() {
        String s = HttpUtil.get(null);
        log.info("{}", s);
    }
}
