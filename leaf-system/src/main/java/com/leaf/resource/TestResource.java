package com.leaf.resource;

import com.leaf.record.Response;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import jakarta.annotation.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jetbrains.annotations.NotNull;

/**
 * 系统测试 controller
 *
 * @author jhlz
 * @version 1.0.0
 */
@Path("/test")
@Resource
public class TestResource {
    private final JSqlClient sqlClient;

    public TestResource(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @GET
    @Path("/users")
    public Page<LeafUser> getUsers() {
        LeafUserTable userTable = LeafUserTable.$;
        @NotNull Page<LeafUser> list = sqlClient.createQuery(userTable)
                .select(userTable)
                .fetchPage(0, 3);
        System.out.println("啊，我累了111222");
        return list;
    }

    @GET
    @Path("/users/{id}")
    public Response getUsers(@RestPath("id") Long id) {
        LeafUser user = sqlClient.findById(LeafUser.class, id);
        return Response.ok(user);
    }

    // @Path("/download")
    // public void download(HttpServletResponse response) {
    //     String filename = "5-权限管理.md";
    //     FileSystemResource resource = new FileSystemResource(LeafConstants.UPLOAD_PATH + File.separator + filename);
    //     try {
    //         InputStream is = resource.getInputStream();
    //         response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
    //         response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
    //         response.getOutputStream().write(is.readAllBytes());
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }
    //
    // @GetMapping("test1")
    // public String test1() {
    //     SecurityContext context = SecurityContextHolder.getContext();
    //     // log.info("{}", SecurityUtil.getAuthentication().getPrincipal());
    //     CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
    //         System.out.println(context.getAuthentication().getPrincipal());
    //     });
    //
    //     try {
    //         System.out.println(voidCompletableFuture.get());
    //     } catch (InterruptedException e) {
    //         throw new RuntimeException(e);
    //     } catch (ExecutionException e) {
    //         throw new RuntimeException(e);
    //     } finally {
    //         SecurityContextHolder.clearContext();
    //     }
    //     return "hello";
    // }
}
