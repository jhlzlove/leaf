package code.simple.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * jsr310 日期格式工具类
 *
 * @author jhlz
 * @since 2022/8/10 15:19
 */
public class LocalDateUtil {

    private static final Logger log = LoggerFactory.getLogger(LocalDateUtil.class);
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * 字符串根据格式转为 LocalDate
     *
     * @param dateStr 字符串日期
     * @param pattern 字符串日期格式，默认为 yyyy-MM-dd
     * @return LocalDate 日期
     */
    public static LocalDate stringToLocalDate(String dateStr, String pattern) {
        String format = StringUtils.hasLength(pattern) ? pattern : DATE_PATTERN;
        return LocalDate.parse(dateStr, ofPattern(format));
    }

    /**
     * LocalDate 转为指定格式的字符串日期
     *
     * @param date    LocalDate 日期
     * @param pattern 格式，默认为 yyyy-MM-dd
     * @return 指定格式的字符串日期
     */
    public static String localDateToString(LocalDate date, String pattern) {
        String format = StringUtils.hasLength(pattern) ? pattern : DATE_PATTERN;
        return date.format(ofPattern(format));
    }

    /**
     * 字符串日期根据指定格式转为 LocalDateTime
     *
     * @param date    字符串日期
     * @param pattern 字符串日期格式
     * @return LocalDateTime 对象
     */
    public static LocalDateTime stringToLocalDateTime(String date, String pattern) {
        String format = StringUtils.hasLength(pattern) ? pattern : DATE_TIME_PATTERN;
        return LocalDateTime.parse(date, ofPattern(format));
    }

    /**
     * LocalDateTime 格式化为指定格式的字符串日期
     *
     * @param date    LocalDateTime 日期
     * @param pattern 格式，默认为 yyyy-MM-dd HH:mm:ss
     * @return 指定格式的字符串日期
     */
    public static String localDateTimeToString(LocalDateTime date, String pattern) {
        String format = StringUtils.hasLength(pattern) ? pattern : DATE_TIME_PATTERN;
        return date.format(ofPattern(format));
    }

    /**
     * 获取指定格式的 DateTimeFormatter
     *
     * @param pattern 格式
     * @return 指定格式的 DateTimeFormatter
     */
    public static DateTimeFormatter ofPattern(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}