package com.jhlz.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import jakarta.inject.Singleton
import org.babyfish.jimmer.jackson.ImmutableModule

/**
 * 自定义 ObjectMapper
 * 注册 jimmer ImmutableModule 模块支持 接口的序列化
 * @author jhlz
 * @version 0.0.1
 */
@Singleton
class JacksonConfig : BeanCreatedEventListener<ObjectMapper> {

    override fun onCreated(event: BeanCreatedEvent<ObjectMapper>): ObjectMapper {
        val bean = event.bean
        bean.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        bean.registerModule(ImmutableModule())
        return bean
    }

}