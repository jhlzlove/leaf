package com.leaf.system.controller;

import com.leaf.common.constant.LeafProperties;
import com.leaf.system.domain.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Controller，此接口 Security 并不拦截
 *
 * @author jhlz
 * @version 1.0.0
 * @since 2023/5/3 11:24
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test01")
    public void get(@RequestBody UserRecord record) {

        System.out.println(leafProperties.getVersion());
        System.out.println(leafProperties.getHeader());

        log.info("record {} ", record);
    }

    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    private final LeafProperties leafProperties;

    public TestController(LeafProperties leafProperties) {
        this.leafProperties = leafProperties;
    }
}
