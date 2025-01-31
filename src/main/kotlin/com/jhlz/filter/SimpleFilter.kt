package com.jhlz.filter

import jakarta.ws.rs.container.ContainerRequestContext
import org.jboss.resteasy.reactive.RestResponse
import java.util.*


/**
 * @author jhlz
 * @version x.x.x
 */
class SimpleFilter {
    // @ServerRequestFilter(preMatching = true)
    fun preMatchingFilter(requestContext: ContainerRequestContext) {
        TODO()
    }

    // @ServerRequestFilter
    fun getFilter(ctx: ContainerRequestContext): Optional<RestResponse<Void>> {
        TODO()
    }
}