package com.example.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author clf
 * @time 2022/8/10 15:19
 * @desc: DateUtil
 */
public class DateUtil {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * yyyy-MM-dd 格式日期字符串转为 LocalDate
     *
     * @param date 字符串日期
     * @return LocalDate
     */
    public static LocalDate string2LocalDate(String date) {
        return string2LocalDate(date, DATE_PATTERN);
    }

    /**
     * LocalDate 转为指定格式的字符串
     *
     * @param date LocalDate 日期
     * @return yyyy-MM-dd 格式的日期
     */
    public static String localDate2String(LocalDate date) {
        return localDate2String(date, DATE_PATTERN);
    }

    /**
     * 字符串转为 LocalDateTime 自定义默认格式
     *
     * @param date 字符串日期
     * @return LocalDateTime
     */
    public static LocalDateTime defaultString2LocalDateTime(String date) {
        return string2LocalDateTime(date, DATE_TIME_PATTERN);
    }

    /**
     * LocalDateTime 转为字符串默认格式
     *
     * @param date LocalDateTime 日期
     * @return 字符串日期
     */
    public static String defaultLocalDateTime2String(LocalDateTime date) {
        return localDateTime2String(date, DATE_TIME_PATTERN);
    }

    /**
     * 字符串转为 LocalDate
     *
     * @param dateStr 字符串日期
     * @param pattern 字符串日期格式
     * @return LocalDate
     */
    public static LocalDate string2LocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDate 转为指定格式的字符串
     *
     * @param date    LocalDate 日期
     * @param pattern 格式
     * @return
     */
    public static String localDate2String(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 指定格式的字符串转为 LocalDateTime
     *
     * @param date    字符串日期
     * @param pattern 字符串日期格式
     * @return
     */
    public static LocalDateTime string2LocalDateTime(String date, String pattern) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTime 格式化为指定格式的字符串
     *
     * @param date    LocalDateTime 日期
     * @param pattern 格式
     * @return
     */
    public static String localDateTime2String(LocalDateTime date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static void main(String[] args) {
        // System.out.println(string2LocalDate("2022/10/1 15:30", "yyyy-MM-dd"));
        System.out.println(localDate2String(LocalDate.now(), "yyyy-MM-dd"));
    }
}