package com.leaf.webtest;

import com.leaf.response.Response;
import com.leaf.util.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author jhlz
 * @since 2023/4/9 13:20
 */
public class SpringResponseEntityTest {

    private static final Logger log = LoggerFactory.getLogger(SpringResponseEntityTest.class);

    /**
     * test: ResponseEntity example
     */
    @Test
    public void spring_ResponseEntityTest() {
        ResponseEntity<String> entity = ResponseEntity.status(200).body("诗酒趁年华");
        ResponseEntity<String> response1 = ResponseEntity.status(HttpStatus.BAD_REQUEST).header("b", "1").body("请求失败！");
        ResponseEntity<Response> ok = ResponseEntity.ok(Response.ok());
        System.out.println(ok);
        System.out.println(JSON.toJson(ok));

        System.out.println(JSON.toJson(response1));
        log.info("{}", response1);
        String s = JSON.toJson(entity);
        log.info("{}", s);
        log.info("{}", entity);

    }
}
