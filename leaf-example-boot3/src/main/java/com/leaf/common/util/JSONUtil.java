package com.leaf.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JacksonJsonParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 基于 Spring 使用的 jackson 简单封装的 JSONUtil
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
    public static String toJSONString(Object o) {
        try {
            return JSON.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json 序列化失败：" + e);
        }
    }

    /**
     * JSON 转对象
     *
     * @param json  json字符串
     * @param clazz 对象类
     * @return
     */
    public static Object parseObject(String json, Class<?> clazz) {
        try {
            return JSON.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json 转 list
     *
     * @param json json 字符串
     * @return List<Object>
     */
    public static List<Object> parseArray(String json) {
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        List<Object> list = jacksonJsonParser.parseList(json);
        return list;
    }

    /**
     * json 转 map
     *
     * @param json json 字符串
     * @return Map<String, Object>
     */
    public static Map<String, Object> parseMap(String json) {
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        Map<String, Object> objects = jacksonJsonParser.parseMap(json);
        return objects;
    }
}
