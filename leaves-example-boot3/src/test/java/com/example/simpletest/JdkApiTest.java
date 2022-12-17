package com.example.simpletest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author jhlz
 * @time 2022/8/29 9:50
 * @desc: JdkApiTest
 */
public class JdkApiTest {
    private static final Logger logger = LoggerFactory.getLogger(JdkApiTest.class);

    /**
     * test: ObjectMapperJSon example
     */
    @Test
    public void testObjectMapperJson() {
        ObjectMapper json = new ObjectMapper();
        try {
            // com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
            // Java 8 date/time type `java.time.LocalDateTime` not supported by default:
            // add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling
            String s = json.writeValueAsString(LocalDateTime.now());
            logger.info("{}", s);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

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

    /**
     * test：Time convert用例
     */
    @Test
    public void testTime() {
        System.out.println(Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8))));
    }

}
