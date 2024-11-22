package com.leaf.framework.response;

import com.leaf.common.record.R;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author jhlz
 * @version 1.0.0
 */
// @Provider
public class GlobalResponse implements MessageBodyWriter<Object> {

    private static final Logger log = LoggerFactory.getLogger(GlobalResponse.class);

    /**
     *
     * @param type the class of instance that is to be written.
     * @param genericType the type of instance to be written, obtained either by reflection of a resource method return type
     * or via inspection of the returned instance. {@link jakarta.ws.rs.core.GenericEntity} provides a way to specify this
     * information at runtime.
     * @param annotations an array of the annotations attached to the message entity instance.
     * @param mediaType the media type of the HTTP entity.
     * @return bool
     */
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type != R.class;
    }

    /**
     *
     * @param o the instance to write.
     * @param type the class of instance that is to be written.
     * @param genericType the type of instance to be written. {@link jakarta.ws.rs.core.GenericEntity} provides a way to
     * specify this information at runtime.
     * @param annotations an array of the annotations attached to the message entity instance.
     * @param mediaType the media type of the HTTP entity.
     * @param httpHeaders a mutable map of the HTTP message headers.
     * @param entityStream the {@link OutputStream} for the HTTP entity. The implementation must not close the output
     * stream.
     * @throws IOException
     * @throws WebApplicationException
     */
    @Override
    public void writeTo(Object o, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        log.info("统一设置返回客户端结构体");
        try (OutputStreamWriter os = new OutputStreamWriter(entityStream);){
            os.write(R.ok(o).toString());
        }
    }
}
