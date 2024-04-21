package com.leaf.simpletest;

import com.leaf.util.JSON;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/8/5 17:24
 */
public class JacksonUtil {

    /**
     * test: jsckson_toList example
     */
    @Test
    public void test() {
        String source = """
                [
                {"name":"jhlz",
                "age": 25},
                {"name":"clf",
                "age":20,
                "date": "2023-08-01"}
                ]
                """;
        String str1 = """
                {"name":"jhlz",
                "age": 25,
                "date": "2023-08-01 23:00:00"
                 }
                """;
        Person person = JSON.parseObject(str1, Person.class);
        System.out.println(person);

        Person p = new Person("风中捉刀", 20, LocalDateTime.now(), LocalDate.now());
        System.out.println(JSON.toJson(p));
    }

    record Person(String name, Integer age, LocalDateTime date, LocalDate localDate) {

    }
}

