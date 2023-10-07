package com.leaf.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author jhlz
 * @since 1.0
 */
@RestController
public class WebTestController {

    private static final Logger log = LoggerFactory.getLogger(WebTestController.class);

    @GetMapping("test")
    public String test1() {
        SecurityContext context = SecurityContextHolder.getContext();
        // log.info("{}", SecurityUtil.getAuthentication().getPrincipal());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(context.getAuthentication().getPrincipal());
        });

        try {
            System.out.println(voidCompletableFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            SecurityContextHolder.clearContext();
        }
        return "hello";
    }
}
