// package com.leaf.filter;
//
// import jakarta.annotation.Priority;
// import jakarta.ws.rs.Priorities;
// import jakarta.ws.rs.container.ContainerRequestContext;
// import jakarta.ws.rs.container.ContainerRequestFilter;
// import jakarta.ws.rs.core.MultivaluedMap;
//
// import java.io.IOException;
// // @Provider
// @Priority(Priorities.AUTHORIZATION + 1)
// public class PageFilter implements ContainerRequestFilter {
//
//     @Override
//     public void filter(ContainerRequestContext requestContext) throws IOException {
//         MultivaluedMap<String, String> params = requestContext.getUriInfo().getQueryParameters(true);
//         String page = params.getFirst("page");
//         String size = params.getFirst("size");
//
//         if (page == null || page.isEmpty()) {
//             params.putSingle("page", "1");
//         }
//         if (size == null || size.isEmpty()) {
//             params.putSingle("size", "10");
//         }
//     }
//
// }
