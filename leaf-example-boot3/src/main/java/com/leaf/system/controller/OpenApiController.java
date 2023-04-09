package com.leaf.system.controller;

import com.leaf.common.constant.LeafProperties;
import com.leaf.system.entity.LeafUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 公共 API
 *
 * @author jhlz
 * @since 2022/8/10 11:45
 */
@RestController
@RequestMapping("/openapi")
public class OpenApiController {


    @GetMapping("/test")
    public void get() {

        System.out.println(leafProperties.getVersion());
        System.out.println(leafProperties.getHeader());
        LeafUser user = new LeafUser();
        user.setId(100L);
        user.setUsername("jhlz");
        user.setUpdateTime(LocalDateTime.now());
    }


    private static final Logger log = LoggerFactory.getLogger(OpenApiController.class);
    private final LeafProperties leafProperties;

    public OpenApiController(LeafProperties leafProperties) {
        this.leafProperties = leafProperties;
    }
}
