package com.jhlz.controller

import com.jhlz.domain.LeafRole
import io.micronaut.http.annotation.*
import org.babyfish.jimmer.sql.kt.KSqlClient
import java.time.OffsetDateTime
import java.time.ZoneOffset

/**
 * @author jhlz
 * @version x.x.x
 */
@Controller("/test")
open class WebController(val sqlClient: KSqlClient) {

    @Delete("/{id}")
    fun getPathVariable(@PathVariable id: Long) {
        println(id)
    }

    @Get
    fun getParameter(@QueryValue username: String) {
        println(username)
    }

    @Post
    open fun add(@Body role: LeafRole):LeafRole{
        val target = LeafRole(role) {
            createTime = OffsetDateTime.now(ZoneOffset.UTC)
        }

        sqlClient.entities.save(target)
        throw Exception("test")
    }
}