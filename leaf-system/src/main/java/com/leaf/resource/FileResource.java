package com.leaf.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.server.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件管理
 *
 * @author jhlz
 * @version 1.0.0
 */
@Path("/file")
public class FileResource {
    private static final Logger log = LoggerFactory.getLogger(FileResource.class);

    // @POST()
    // @Path("spring-upload")
    // public void uploadMultipartFile(@Param("files") MultipartFile[] files) {
    //     for (MultipartFile file : files) {
    //         upload(file);
    //     }
    // }


    /**
     * 文件上传
     */
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void upload( MultipartFormDataInput file) {

    }
    //
    // /**
    //  * 文件下载
    //  */
    // @GetMapping("download")
    // public void download(@RequestParam("filename") String filename, HttpServletResponse response) {
    //     String encodeName = URLEncoder.encode(filename, StandardCharsets.UTF_8);
    //     FileSystemResource resource = new FileSystemResource(LeafConstants.UPLOAD_PATH + File.separator + filename);
    //     try (InputStream is = resource.getInputStream()) {
    //         response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encodeName);
    //         response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
    //         response.getOutputStream().write(is.readAllBytes());
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }
}
