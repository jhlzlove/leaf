package com.leaf.controller;

import com.leaf.constant.LeafConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * 文件上传下载
 *
 * @author jhlz
 * @version 1.0.0
 */
@Tag(name = "file")
@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @PostMapping("spring-upload")
    public void uploadMultipartFile(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            upload(file);
        }
    }

    /**
     * 使用 Servlet 方式上传，支持多文件上传
     *
     * @param req  请求
     * @param resp 响应
     */
    @PostMapping("upload")
    public void upload(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            for (Part part : req.getParts()) {
                log.debug("上传的文件参数名称：{}", part.getName());
                String sourceFileName = part.getSubmittedFileName();
                log.info("上传的源文件名称：{}", sourceFileName);
                log.info("上传的源文件类型：{}", part.getContentType());
                String suffix = sourceFileName.substring(sourceFileName.lastIndexOf("."));
                String newFilename = UUID.randomUUID().toString().replace("-", "");
                InputStream is = part.getInputStream();
                String filePath = LeafConstants.UPLOAD_PATH + File.separator + newFilename + suffix;
                File f = new File(filePath);
                if (!f.getParentFile().exists()) f.getParentFile().mkdirs();
                Files.copy(is, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException | ServletException e) {
            log.error("文件上传失败！{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Spring MVC 3.1 MultipartFile 方式上传文件
     *
     * @param file MultipartFile
     */
    private void upload(MultipartFile file) {
        String sourceFileName = file.getOriginalFilename();
        log.info(" File name is {}", sourceFileName);
        String suffix = sourceFileName.substring(sourceFileName.lastIndexOf("."));
        log.info(" File extension name is {}", suffix);
        String home = System.getProperty("user.dir");
        String newFilename = UUID.randomUUID().toString().replace("-", "");
        String filePath = home + File.separator + LeafConstants.UPLOAD_PATH + File.separator + newFilename + suffix;
        log.info("文件名称：{}", filePath);
        try {
            File destFile = new File(filePath);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
        } catch (IOException e) {
            log.error("文件上传失败！{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件下载
     */
    @GetMapping("download")
    public void download(@RequestParam("filename") String filename, HttpServletResponse response) {
        String encodeName = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        FileSystemResource resource = new FileSystemResource(LeafConstants.UPLOAD_PATH + File.separator + filename);
        try (InputStream is = resource.getInputStream()) {
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encodeName);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.getOutputStream().write(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
