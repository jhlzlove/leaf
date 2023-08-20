package com.leaf.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/8/6 14:01
 */
@org.springframework.boot.test.autoconfigure.json.JsonTest
public class JsonTest {

    @Autowired
    JacksonTester<Account> tester;

    /**
     * test: jackson_tester example
     */
    @Test
    public void jackson_test() {
        Account account = new Account("楚", "凛风", 20);
        try {
            JsonContent<Account> content = tester.write(account);

            String json = content.getJson();
            System.out.println(json);
            Assertions.assertEquals(json, """
                    {
                        "firstName":"楚",
                        "lastName":"凛风",
                        "age":20
                    }
                    """);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    record Account(String firstName, String lastName, Integer age) {
    }

}
