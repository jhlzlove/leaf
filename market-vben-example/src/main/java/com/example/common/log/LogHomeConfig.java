package com.example.common.log;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @author jhlz
 * @time 2022/8/29 9:47
 * @desc: LogHomeConfig
 * 继承 logback 的 PropertyDefinerBase 实现动态确定 logs 的存放路径
 */
public class LogHomeConfig extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        // 获取用户名
        String username = System.getProperty("user.name");
        // 获取操作系统
        String os = System.getProperty("os.name");
        return os.toLowerCase().contains("window") ? "D:/market/logs" : "/home/" + username + "/market/logs";
    }
}
