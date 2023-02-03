package com.leaves.simpletest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
     * test: Md5 example
     */
    @Test
    public void testMd5() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // String path = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "static/data/upload/out3.txt";
            // ResourceLoader.CLASSPATH_URL_PREFIX +
            Resource resource = new ClassPathResource("static\\data\\upload\\out3.txt");
            try {
                byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
                String content = new String(bdata, StandardCharsets.UTF_8);
                md5.update(bdata);
                logger.info(content);
            } catch (IOException e) {
                logger.error("IOException", e);
            }
            System.out.println("classPathResource.getDescription() = " + resource.getDescription());
            System.out.println("classPathResource.getFile() = " + resource.getFile());
            System.out.println("classPathResource.getFilename() = " + resource.getFilename());
            System.out.println("classPathResource.getURL() = " + resource.getURL());
            System.out.println("classPathResource.getURI() = " + resource.getURI());


            String secret = new BigInteger(1, md5.digest()).toString(16);
            logger.info("{}", secret);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
        System.out.println(os.toLowerCase().contains("linux") ? "./logs" : "/home/" + username + "/logs");
    }

    /**
     * test：Time convert用例
     */
    @Test
    public void testTime() {
        System.out.println(Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8))));
    }

}
