package com.leaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeGenerationApplication {

    private static final Logger log = LoggerFactory.getLogger(CodeGenerationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CodeGenerationApplication.class, args);
        log.info("代码生成模块启动成功！");
    }
}