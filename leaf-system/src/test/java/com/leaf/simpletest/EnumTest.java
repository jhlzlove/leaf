package com.leaf.simpletest;

import com.leaf.business.BusinessEnum;
import org.junit.jupiter.api.Test;

/**
 * @author jhlz
 * @version 1.0.0
 * @since 2023/5/4 22:09
 */
public class EnumTest {

    /**
     * test: enum example
     */
    @Test
    public void enumTest() {
        System.out.println(BusinessEnum.UNKNOWN);
    }
}
