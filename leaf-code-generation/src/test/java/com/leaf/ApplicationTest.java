package com.leaf;

import com.leaf.util.DbUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/17 13:24
 */
@SpringBootTest(classes = {CodeGenerationApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
    @Autowired
    private DbUtil dbUtil;

    /**
     * test: dbUtil example
     */
    @Test
    public void DButiltest() {
        List<String> allDatabases = dbUtil.getAllDatabases();
        System.out.println(allDatabases);
        System.out.println(dbUtil.getAllTables());
    }
}
