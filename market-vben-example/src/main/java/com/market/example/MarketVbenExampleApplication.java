package com.market.example;

import com.market.example.utils.IpUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
//扫描mapper
@MapperScan("com.market.example.mapper")
public class MarketVbenExampleApplication {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(MarketVbenExampleApplication.class, args);
        System.out.println("swagger 地址：http://" + IpUtil.getLocalUrl() + ":8080/swagger-ui/index.html");
    }

}
