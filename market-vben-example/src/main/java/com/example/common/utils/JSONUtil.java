package com.example.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 基于 Spring 使用的 jackson 封装的 JSONUtil
 *
 * @author jhlz
 * @time 2022/8/19 18:52
 */
public class JSONUtil {

    // 先不配置 jackson 的配置项，直接定义
    private final static ObjectMapper JSON = new ObjectMapper();

    /**
     * 转换为 JSON 字符串
     *
     * @param o 需要转换的数据
     * @return
     */
    public static String toJSON(Object o) {
        try {
            return JSON.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json 序列化失败：" + e);
        }
    }

    /**
     * JSON 转对象
     *
     * @param jsonStr json字符串
     * @param clazz   对象类
     * @return
     */
    public static Object parserObject(String jsonStr, Class<?> clazz) {
        try {
            return JSON.readValue(jsonStr, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
