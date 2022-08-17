package com.example;

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

    @org.junit.jupiter.api.Test
    public void test() {
        System.out.println(passwordEncoder.encode("clf"));
    }
}
