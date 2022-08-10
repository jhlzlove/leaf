package com.market.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootApplication
public class MarketVbenExampleApplication {

    @Value("${server.port}")
    private static String port;
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(MarketVbenExampleApplication.class, args);
        System.out.println("swagger 地址：http://" + Inet4Address.getLocalHost().getHostAddress() +
                ":" + port + "/swagger-ui/index.html");
    }

}
