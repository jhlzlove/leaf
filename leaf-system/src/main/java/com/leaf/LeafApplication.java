package com.leaf;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class LeafApplication {

    public static void main(String... args) {
        Quarkus.run(args);
        // log.info("http://{}:{}/api/v3/api-docs", IpUtil.getLocalUrl(), SpringUtil.getPort());
        // yaml 格式文件，点击下载文件
        // log.info("http://{}:{}/api/v3/api-docs.yaml", IpUtil.getLocalUrl(), SpringUtil.getPort());
    }
}