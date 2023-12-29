package com.leaf.controller;

import com.leaf.constant.LeafConstants;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 系统测试 controller
 *
 * @author jhlz
 * @since 1.0
 */
@RequestMapping("/test")
@RestController
public class WebTestController {

    private static final Logger log = LoggerFactory.getLogger(WebTestController.class);

    @GetMapping("download")
    public void download(HttpServletResponse response) {
        String filename = "5-权限管理.md";
        FileSystemResource resource = new FileSystemResource(LeafConstants.UPLOAD_PATH + File.separator + filename);
        try {
            InputStream is = resource.getInputStream();
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.getOutputStream().write(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("test1")
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
