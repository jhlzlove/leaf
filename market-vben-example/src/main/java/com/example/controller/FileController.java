package com.example.controller;

import com.example.common.annotation.ApiRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource("data/download/" + fileName);
        String absoluteFilePath = resource.getFile();
        Path fileBasePath = Paths.get(absoluteFilePath.replaceFirst("/", ""));
        logger.info("下载的文件名：{}", fileBasePath.getFileName());

        // try-with-resources
        File file = fileBasePath.toFile();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
        ) {
            // 设置 response 的Header
            resp.setCharacterEncoding("UTF-8");
            resp.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            resp.addHeader("Content-Length", "" + file.length());
            resp.setContentType("application/octet-stream");
            byte[] buffer = new byte[1024];
            bos.write(buffer);
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
                uploadFiles(f, "", "", "");
            });
            req.getInputStream();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }


    private void uploadFiles(Part part, String uploadFileDirPath, String frontEndFileInputName, String renameFileName) {
        String uploadFileWholeDirPath = "";
        if (part.getName().equals(frontEndFileInputName)) {
            String cd = part.getHeader("Content-Disposition");
            String[] cds = cd.split(";");
            String filename = cds[2].substring(cds[2].indexOf("=") + 1).substring(cds[2].lastIndexOf("//") + 1).replace("\"", "");
            String ext = filename.substring(filename.lastIndexOf(".") + 1);

            logger.info("filename:" + filename);
            logger.info("ext:" + ext);

            InputStream is = null;
            try {
                is = part.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (Arrays.binarySearch(ImageIO.getReaderFormatNames(), ext) >= 0)
                uploadImageProcess(uploadFileDirPath, filename, ext, is);
            else {
                uploadCommonFileProcess(uploadFileDirPath, filename, is);
            }
            if (null != renameFileName && !"".equals(renameFileName)) {
                uploadFileWholeDirPath = uploadFileDirPath + renameFileName + ext;
            } else {
                uploadFileWholeDirPath = uploadFileDirPath + filename;
            }
        }
    }

    /**
     * 通用文件上传处理
     *
     * @param uploadFileDirPath
     * @param filename
     * @param is
     */
    private void uploadCommonFileProcess(String uploadFileDirPath, String filename, InputStream is) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(uploadFileDirPath + filename));
            int b = 0;
            while ((b = is.read()) != -1) {
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 图片文件上传处理
     *
     * @param uploadFileDirPath
     * @param filename
     * @param ext
     * @param is
     * @throws IOException
     */
    public void uploadImageProcess(String uploadFileDirPath, String filename, String ext, InputStream is) {
        Iterator<ImageReader> irs = ImageIO.getImageReadersByFormatName(ext);
        ImageReader ir = irs.hasNext() ? irs.next() : null;
        if (ir == null)
            return;
        // 必须转换为ImageInputStream，否则异常
        try {
            ir.setInput(ImageIO.createImageInputStream(is));


            ImageReadParam rp = ir.getDefaultReadParam();
            Rectangle rect = new Rectangle(0, 0, 200, 200);
            rp.setSourceRegion(rect);

            // allowSearch必须为true，否则有些图片格式imageNum为-1。
            int imageNum = ir.getNumImages(true);
            logger.info("imageNum:" + imageNum);
            for (int imageIndex = 0; imageIndex < imageNum; imageIndex++) {
                BufferedImage bi = ir.read(imageIndex, rp);
                ImageIO.write(bi, ext, new File(uploadFileDirPath + filename));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        FileController controller = new FileController();
        ClassLoader classLoader = controller.getClass().getClassLoader();
        URL resource = classLoader.getResource("data/download/file.txt");
        logger.info("{}", resource.getFile());
        logger.info("{}", resource.getProtocol());
        controller.fileDownload(null, null, "file.txt");
    }
}
