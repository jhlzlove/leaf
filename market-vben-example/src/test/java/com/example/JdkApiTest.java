package com.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhlz
 * @time 2022/8/29 9:50
 * @desc: JdkApiTest
 */
public class JdkApiTest {
    private static final Logger logger = LoggerFactory.getLogger(JdkApiTest.class);

    /**
     * test：测试获取操作系统信息
     */
    @Test
    public void testOs() {
        // System.out.println(System.getenv());
        String username = System.getProperty("user.name");
        String os = System.getProperty("os.name");
        System.out.println("系统名称：" + os);
        System.out.println("系统架构：" + System.getProperty("os.arch"));
        System.out.println("系统版本：" + System.getProperty("os.version"));
        System.out.println(os.toLowerCase().contains("linux") ? "D:/market/logs" : "/home/" + username + "/logs");
    }
}
