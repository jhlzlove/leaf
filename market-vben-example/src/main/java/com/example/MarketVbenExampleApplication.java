package com.example;

import com.example.common.constant.GlobalConstants;
import com.example.common.utils.IpUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.*;
import java.net.UnknownHostException;

@SpringBootApplication
//扫描mapper
@MapperScan("com.example.mapper")
public class MarketVbenExampleApplication {

    public static void main(String[] args) throws UnknownHostException, ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, MalformedObjectNameException {
        SpringApplication.run(MarketVbenExampleApplication.class, args);
        System.out.println("swagger 地址：http://" + IpUtil.getLocalUrl() + ":" +
                GlobalConstants.PORT + GlobalConstants.SWAGGER_SUFFIX);
    }
}