package com.example;

import com.example.common.constant.GlobalConstants;
import com.example.common.utils.IpUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketVbenExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketVbenExampleApplication.class, args);
        System.out.println("swagger 地址：http://" + IpUtil.getLocalUrl() + ":" +
                GlobalConstants.PORT + GlobalConstants.SWAGGER_SUFFIX);
    }
}