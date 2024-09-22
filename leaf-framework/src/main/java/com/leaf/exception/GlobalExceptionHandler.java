package com.leaf.exception;

import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * 全局异常信息处理
 *
 * @author jhlz
 * @version 1.0.0
 */

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Inject
    jakarta.inject.Provider<ContainerRequestContext> requestContextProvider;

    @Override
    public Response toResponse(Exception exception) {
        return mapExceptionToResponse(exception);
    }

    private Response mapExceptionToResponse(Exception exception) {
        // Use response from WebApplicationException as they are
        if (exception instanceof WebApplicationException) {
            // Overwrite error message
            Response originalErrorResponse = ((WebApplicationException) exception).getResponse();
            return Response.fromResponse(originalErrorResponse)
                    .entity(exception.getMessage())
                    .build();
        }
        // Special mappings
        else if (exception instanceof IllegalArgumentException) {
            return Response.status(400).entity(exception.getMessage()).build();
        }
        return Response.status(500).entity(exception.getMessage()).build();
    }
}
