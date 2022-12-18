package com.example;

import com.example.common.utils.EnvironmentUtil;
import com.example.common.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketVbenExampleApplication {

    private static final Logger log = LoggerFactory.getLogger(MarketVbenExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MarketVbenExampleApplication.class, args);
        log.info("swagger 地址：http://{}:{}", IpUtil.getLocalUrl(), EnvironmentUtil.getPort());

    }
}