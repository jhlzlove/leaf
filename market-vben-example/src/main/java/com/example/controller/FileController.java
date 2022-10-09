package com.example.controller;

import com.example.common.annotation.ApiRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

/**
 * FileController:
 * 文件的上传下载
 *
 * @author jhlz
 * @since 2022/10/5 16:39:06
 */
@ApiRestController
@RequestMapping("file")
@Api(value = "FileController", tags = "文件上传下载管理")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @GetMapping("download")
    @ApiOperation(value = "fileDownload", notes = "文件下载")
    public HttpServletResponse fileDownload(HttpServletRequest req,
                                            HttpServletResponse resp,
                                            String fileName) {
        // 可下载的资源全部放在该路径
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource("static/data/download/" + fileName);
        // 获取绝对路径，注意：该方式的绝对路径前有 /
        String absoluteFilePath = resource.getFile();
        Path fileBasePath = Paths.get(absoluteFilePath.replaceFirst("/", ""));
        logger.info("下载的文件名：{}", fileBasePath.getFileName());

        File file = fileBasePath.toFile();
        // try-with-resources
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
        ) {
            // 设置 response 的Header
            resp.setCharacterEncoding("UTF-8");
            resp.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            resp.addHeader("Content-Length", "" + file.length());
            resp.setContentType("application/octet-stream");
            byte[] buffer = new byte[1024];
            int b;
            while ((b = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, b);// 将缓冲区的数据输出到浏览器
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resp;
    }

    @PostMapping("upload")
    @ApiOperation(value = "upload", notes = "文件上传")
    public void upload(HttpServletRequest req, HttpServletResponse resp, String file) {
        try {
            req.setCharacterEncoding("UTF-8");

            Collection<Part> parts = req.getParts();
            Iterator<Part> fileIterator = parts.iterator();
            fileIterator.forEachRemaining(f -> {
                logger.info("类型名称：{}", f.getName());
                logger.info("提交的文件名称：{}", f.getSubmittedFileName());
                try {
                    logger.info("上传的文件流{}", f.getInputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // uploadFiles(f, "market-vben-example/src/main/resources/data", f.getName(), Instant.now().toString());
            });
            req.getInputStream();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
