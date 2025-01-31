package com.jhlz.response

import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.MultivaluedMap
import jakarta.ws.rs.ext.MessageBodyWriter
import jakarta.ws.rs.ext.Provider
import java.io.OutputStream
import java.lang.reflect.Type

/**
 * @author jhlz
 * @version 1.0.0
 */
@Provider
class GlobalResponse : MessageBodyWriter<Any?> {
    override fun isWriteable(p0: Class<*>?, p1: Type?, p2: Array<out Annotation>?, p3: MediaType?): Boolean {
        return false
    }

    override fun writeTo(
        p0: Any?,
        p1: Class<*>?,
        p2: Type?,
        p3: Array<out Annotation>?,
        p4: MediaType?,
        p5: MultivaluedMap<String, Any>?,
        p6: OutputStream?
    ) {

    }

}
