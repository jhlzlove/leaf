package com.leaf.framework.common.simple;

import com.leaf.framework.exception.BusinessEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jhlz
 */
public class EnumTest {

    /**
     * test: enum example·
     */
    @Test
    public void enumTest() {
        // System.out.println(new PageRecord());
        Assertions.assertEquals("未知", BusinessEnum.UNKNOWN.getModule());
        System.out.println(BusinessEnum.UNKNOWN);
    }
}
