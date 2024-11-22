// package com.leaf.framework.response;
//
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.leaf.framework.record.PageRecord;
// import jakarta.ws.rs.WebApplicationException;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.MultivaluedMap;
// import jakarta.ws.rs.ext.MessageBodyReader;
//
// import java.io.IOException;
// import java.io.InputStream;
// import java.lang.annotation.Annotation;
// import java.lang.reflect.Type;
//
// /**
//  * @author jhlz
//  * @version 1.0.0
//  */
// // @Provider
// public class PageRecordReader implements MessageBodyReader<PageRecord> {
//
//     @Override
//     public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType) {
//         return type.equals(PageRecord.class);
//     }
//
//     @Override
//     public PageRecord readFrom(Class<PageRecord> clazz, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
//         ObjectMapper mapper = new ObjectMapper();
//         PageRecord pageRecord = mapper.readValue(inputStream, PageRecord.class);
//         if (pageRecord != null) return pageRecord;
//         return new PageRecord(1, 10);
//     }
// }
