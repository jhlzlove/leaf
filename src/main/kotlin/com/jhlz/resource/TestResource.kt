package com.jhlz.resource

import com.jhlz.common.log.Log
import com.jhlz.domain.LeafUser
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.babyfish.jimmer.sql.kt.KSqlClient

/**
 * @author jhlz
 * @version x.x.x
 */
@Path("/test")
class TestResource(val sqlClient: KSqlClient) {

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Log(module = "添加用户")
    @Transactional(rollbackOn = [Exception::class])
    fun add(user: LeafUser): Long {
        val result = sqlClient.save(user)
        // modifiedEntity 在 originalEntity 的基础上添加了 id
        println("modifiedEntity is " + result.modifiedEntity)
        println("originalEntity is " + result.originalEntity)
        return result.modifiedEntity.id
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Log(module = "获取用户列表")
    fun list() = sqlClient.createQuery(LeafUser::class) {
        select(table)
    }.execute()

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Log(module = "测试")
    fun hello() = "Hello World!"
}