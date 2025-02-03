package com.jhlz.config

import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.jackson.ObjectMapperCustomizer
import jakarta.enterprise.context.ApplicationScoped
import org.babyfish.jimmer.jackson.ImmutableModule

@ApplicationScoped
class JacksonConfig: ObjectMapperCustomizer {
    override fun customize(objectMapper: ObjectMapper) {
        objectMapper.registerModule(ImmutableModule())
    }
}