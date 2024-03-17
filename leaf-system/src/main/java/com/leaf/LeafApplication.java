package com.leaf;

import com.leaf.util.IpUtil;
import com.leaf.util.SpringUtil;
import org.babyfish.jimmer.spring.repository.EnableJimmerRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJimmerRepositories("com.leaf.repository")
public class LeafApplication {

    private static final Logger log = LoggerFactory.getLogger(LeafApplication.class);

    public static void main(String[] args) {
        System.setProperty("spring.devtools.add-properties", "false");
        SpringApplication.run(LeafApplication.class, args);
        // 开启 Spring Security 子线程共享信息策略
        // SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        log.info("http://{}:{}/api/v3/api-docs", IpUtil.getLocalUrl(), SpringUtil.getPort());
        // yaml 格式文件，点击下载文件
        log.info("http://{}:{}/api/v3/api-docs.yaml", IpUtil.getLocalUrl(), SpringUtil.getPort());
    }
}