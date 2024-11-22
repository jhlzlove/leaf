package com.leaf.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jhlz
 */
public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * example:
     **/
    @Test
    public void jwt_Test() {
        Assertions.assertEquals(0, Gender.MALE.ordinal());
        System.out.println(Gender.FEMALE.ordinal());
    }
    enum Gender {
        MALE, FEMALE
    }
}
