package com.leaf.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

/**
 * @auther jhlz
 * @since 2023/2/16 9:53
 */
public class WebTest {

    private RouterFunction<ServerResponse> routingFunction() {
        return route(GET("/t?st"),
                serverRequest -> ok().body(("Path /t?st is accessed")));
    }

    /**
     * test: passwordEncoder_SpringSecurity example
     */
    @Test
    public void passwordEncoder_SpringSecurityTest() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // String password = passwordEncoder.encode("admin");
        // System.out.println(password);
    }

}
