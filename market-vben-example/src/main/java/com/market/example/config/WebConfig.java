package com.market.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author clf
 * @time 2022/8/10 11:31
 * @desc: WebConfig
 */
@Component
@MapperScan("com.market.example.mapper")
public class WebConfig {
}
