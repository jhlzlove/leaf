package com.example;

import com.example.mapper.SysMenuMapper;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author clf
 * @time 2022/8/11 18:10
 * @desc: Test
 */
@SpringBootTest
public class Test {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @org.junit.jupiter.api.Test
    public void test() {
        System.out.println(passwordEncoder.encode("clf"));
    }

    /**
     * test：
     */
    @org.junit.jupiter.api.Test
    public void testListMenu() {
        Assertions.assertTrue(sysMenuMapper.listMenu() != null);
        System.out.println(sysMenuMapper.listMenu());
    }
}
