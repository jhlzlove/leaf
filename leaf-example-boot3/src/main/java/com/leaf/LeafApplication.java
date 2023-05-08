package com.leaf;

import com.leaf.common.util.IpUtil;
import com.leaf.common.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class LeafApplication {

    private static final Logger log = LoggerFactory.getLogger(LeafApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LeafApplication.class, args);
        // 开启 Spring Security 子线程共享信息策略
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        log.info("http://{}:{}", IpUtil.getLocalUrl(), SpringUtil.getPort());
    }
}