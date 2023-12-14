package com.leaf.system.controller;

import com.leaf.common.util.LocalDateUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;

/**
 * 文件上传下载
 *
 * @author jhlz
 * @since 2022/10/5 16:39:06
 */
@Tag(name = "文件管理")
@RequestMapping("/file")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    /**
     * request 方式上传
     *
     * @param req
     * @param resp
     * @param file
     */
    @PostMapping("/upload")
    public void upload(HttpServletRequest req, HttpServletResponse resp, String file) {
        try {
            req.setCharacterEncoding("UTF-8");
            Collection<Part> parts = req.getParts();
            Iterator<Part> fileIterator = parts.iterator();
            fileIterator.forEachRemaining(f -> {
                log.info("类型名称：{}", f.getName());
                log.info("提交的文件名称：{}", f.getSubmittedFileName());
                try {
                    log.info("上传的文件流{}", f.getInputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // uploadFiles(f, "market-vben-example/src/main/resources/data", f.getName(), Instant.now().toString());
            });
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("MultipartFile")
    public void uploadMultipartFile(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            upload(file);
        }
    }

    /**
     * Spring MVC 3.1 MultipartFile 方式上传文件
     *
     * @param file
     */
    private void upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        log.debug(" File name is {}", fileName);
        String[] fileSplit = fileName.split("\\.");
        String extensionName = fileSplit[fileSplit.length - 1];
        log.debug(" File extension name is {}", extensionName);

        String rename = LocalDateUtil.localDateTimeToString(LocalDateTime.now(), "yyyyMMddHHmmsss");
        String finalName = rename + "." + extensionName;
        try {
            File filePath = new File("./src/main/resources/static/data/upload/");
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            File saveFile = new File(filePath + finalName);
            file.transferTo(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
