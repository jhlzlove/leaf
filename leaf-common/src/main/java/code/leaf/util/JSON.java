package code.simple.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * 基于 Spring 使用的 jackson 简单封装的 JSON 工具类
 *
 * @author jhlz
 * @since 2022/8/19 18:52
 */
public class JSON {

    private static final ObjectMapper JSON;

    static {
        ObjectMapper temp = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        DateTimeFormatter dateTimeFormatter = LocalDateUtil.ofPattern(LocalDateUtil.DATE_TIME_PATTERN);
        DateTimeFormatter dateFormatter = LocalDateUtil.ofPattern(LocalDateUtil.DATE_PATTERN);
        module.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
        // 注册 module
        temp.registerModule(module);
        // 忽略未知字段
        temp.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        JSON = temp;
    }

    /**
     * 转换为 JSON 字符串
     *
     * @param o 需要转换的数据
     * @return json 格式字符串
     */
    public static String toJson(@NonNull Object o) {
        try {
            return JSON.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json 序列化失败：" + e.getMessage());
        }
    }

    public static String toPrettyJson(@NonNull Object o) {
        try {
            return JSON.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json 序列化失败：" + e.getMessage());
        }
    }

    /**
     * JSON 转对象
     *
     * @param json  json字符串
     * @param clazz 对象类
     * @return 对象
     */
    public static <T> T parseObject(@NonNull String json, @NonNull Class<T> clazz) {
        try {
            return JSON.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("json 反序列化对象 IO 异常：" + e.getMessage());
        }
    }

    /**
     * json 转对象集合
     *
     * @param json  json 字符串
     * @param clazz 指定的对象类别
     * @return 对象集合
     */
    public static <T> List<T> toList(@NonNull String json, @NonNull Class<T> clazz) {
        try {
            return JSON.readValue(json, JSON.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException("json 反序列化对象集合 IO 异常：" + e.getMessage());
        }
    }

    /**
     * json 转 map
     *
     * @param json json 字符串
     * @return Map<String, Object>
     */
    public static Map<String, Object> toMap(String json) {
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser(JSON);
        return jacksonJsonParser.parseMap(json);
    }
}
