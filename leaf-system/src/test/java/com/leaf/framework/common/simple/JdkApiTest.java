package com.leaf.framework.common.simple;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * @author jhlz
 */
public class JdkApiTest {
    private static final Logger logger = LoggerFactory.getLogger(JdkApiTest.class);

    /**
     * test: eclipseCollections example
     */
    @Test
    public void collectionsTest() {


        List<Object> list = Collections.singletonList(123);
        System.out.println(list);


        Map<Object, Object> map = Collections.singletonMap("1", 2);
        System.out.println(map);

    }

    /**
     * test: Md5 example
     */
    /* @Test
    public void testMd5() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String path = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "static/data/upload/out3.txt";
            ResourceLoader.CLASSPATH_URL_PREFIX +
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
    } */

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

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR) + ", " + calendar.get(Calendar.MONTH) + 1 + ", " + calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate now = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println("date = " + date);
        System.out.println("now = " + now);
        System.out.println(Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8))));
    }

}