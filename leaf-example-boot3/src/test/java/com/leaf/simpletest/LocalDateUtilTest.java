package com.leaf.simpletest;

import com.leaf.common.util.LocalDateUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * LocalDateUtil test
 *
 * @author jhlz
 * @since 2023/3/1 9:26
 */
public class LocalDateUtilTest {

    private static final Logger log = LoggerFactory.getLogger(LocalDateUtilTest.class);

    /**
     * test: stringToLocalDate example
     */
    @Test
    public void stringToLocalDateTest() {
        String str1 = "2023/1/1";
        LocalDate localDate =
                LocalDateUtil.stringToLocalDate(str1, "yyyy/M/d");
        log.info("{}", localDate);
    }

    /**
     * test: stringToLocalDateTime example
     */
    @Test
    public void stringToLocalDateTimeTest() {
        String str1 = "2023/1/1 12-00-01";

        LocalDate localDate =
                LocalDateUtil.stringToLocalDate(str1, "yyyy/M/d HH-mm-ss");
        log.info("{}", localDate);

        LocalDateTime localDateTime =
                LocalDateUtil.stringToLocalDateTime(str1, "yyyy/M/d HH-mm-ss");
        log.info("{}", localDateTime);

    }

    /**
     * test: localDateToString example
     */
    @Test
    public void localDateToStringTest() {
        LocalDate now = LocalDate.now();
        String str = LocalDateUtil.localDateToString(now, "yyyy-MM-dd");
        log.info("{}", str);
    }

    /**
     * test: localDateTimeToString example
     */
    @Test
    public void localDateTimeToStringTest() {
        LocalDateTime now = LocalDateTime.now();
        String s = LocalDateUtil.localDateTimeToString(now, "yyyy-MM-dd HH:mm:ss.SSS");
        log.info("{}", s);
    }
}
