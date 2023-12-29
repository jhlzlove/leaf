package com.leaf.util;

import java.util.UUID;

public class UUIDUtil {
    /**
     * 生成并返回一个去掉"-"的UUID字符串
     *
     * @return 去掉"-"的UUID字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
