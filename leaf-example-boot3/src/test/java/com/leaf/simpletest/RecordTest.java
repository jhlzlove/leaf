package com.leaf.simpletest;

import com.leaf.common.response.Response;
import com.leaf.system.entity.UserRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author jhlz
 * @since 2023/2/27 9:10
 */
public class RecordTest {

    private static final Logger log = LoggerFactory.getLogger(RecordTest.class);

    /**
     * test: Java17Record example
     */
    @Test
    public void testJava17Record() {
        UserRecord userRecord = new UserRecord("jhlz", 20, LocalDateTime.now());

        UserRecord userRecord1 = new UserRecord(null, null, null);

        // userRecord1.age()
        System.out.println("userRecord: " + userRecord);
        System.out.println("userRecord1: " + userRecord1);


        Record copy = userRecord.copy();

        Assertions.assertEquals(userRecord, copy);

        System.out.println("userRecord1: " + copy);


    }

    /**
     * test: responseRecord example
     */
    @Test
    public void responseRecordTest() {
        Response resultResponse = new Response(100, "123");
        System.out.println(resultResponse);

        System.out.println(Response.success());
    }
}
