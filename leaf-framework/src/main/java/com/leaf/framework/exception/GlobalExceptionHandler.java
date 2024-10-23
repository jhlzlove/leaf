package com.leaf.framework.exception;

import com.leaf.common.record.R;
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
        R r = mapExceptionToResponse(exception);
        return Response.ok(r).build();
    }

    private R mapExceptionToResponse(Exception exception) {
        return switch (exception) {
            case ServiceException e -> R.error(e.getException().getCode(), e.getException().getMessage());
            case WebApplicationException e -> R.error(e.getMessage());
            case null, default -> R.error();
        };
    }
}
