package com.leaf.common.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 获取程序运行时的环境参数
 *
 * @author: jhlz
 * @since: 2022/11/14 8:32:00
 */
@Component
public class EnvironmentUtil implements EnvironmentAware {

    /**
     * 端口号
     *
     * @return
     */
    public static String getPort() {
        return environment.getProperty("server.port");
    }

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        EnvironmentUtil.environment = environment;
    }

    private static Environment environment;
}
