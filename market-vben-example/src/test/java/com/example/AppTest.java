package com.example;

import com.example.service.SysMenuService;
import com.example.service.SysUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author clf
 * @time 2022/8/11 18:10
 * @desc: Test
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMenuService menuService;

    @Test
    public void test() {
        logger.info("{}", userService.loadUserByUsername("jhlz"));
    }

    /**
     * test：删除账户用例
     */
    @Test
    public void testDeleteUser() {
        Assertions.assertTrue(userService.delete(4L).getDelFlag() == true);
    }

    /**
     * test：获取菜单树用例
     */
    @Test
    public void testListMenu() {
        // logger.info("{}", menuService.getMenuList());
    }
}
