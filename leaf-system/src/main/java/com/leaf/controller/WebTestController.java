package com.leaf.controller;

import com.leaf.common.response.Response;
import com.leaf.constant.LeafConstants;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import com.leaf.service.LeafUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @version 1.0.0
 */
@RestController
@RequestMapping("/test")
public class WebTestController {

    private static final Logger log = LoggerFactory.getLogger(WebTestController.class);
    private final LeafUserService userService;

    private final JSqlClient sqlClient;

    public WebTestController(LeafUserService userService, JSqlClient sqlClient) {
        this.userService = userService;
        this.sqlClient = sqlClient;
    }

    @GetMapping("/users")
    public Page<LeafUser> getUsers() {
        LeafUserTable userTable = LeafUserTable.$;
        @NotNull Page<LeafUser> list = sqlClient.createQuery(userTable)
                .select(userTable)
                .fetchPage(0, 3);
        return list;
        // return userService.listPage(PageRequest.of(0, 1));
        // return Response.ok();
    }

    @GetMapping("/users/{id}")
    public Response getUsers(@PathVariable("id") Long id) {

        LeafUser user = sqlClient.findById(LeafUser.class, id);
        return Response.ok(user);
        // return Response.ok(userService.findById(id));
    }

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
