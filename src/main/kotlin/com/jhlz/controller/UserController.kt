package com.jhlz.controller

import com.jhlz.domain.LeafUser
import com.jhlz.record.PageQuery
import com.jhlz.service.LeafUserService
import io.micronaut.http.annotation.*

/**
 * @author jhlz
 * @version 0.0.1
 */
@Controller("/user")
open class UserController(val userService: LeafUserService) {

    @Get
    open fun page(@RequestBean pageQuery: PageQuery) = userService.page(pageQuery)

    @Get("/{id}")
    open fun info(@PathVariable id: Long) = userService.info(id)

    @Post
    open fun add(@Body user: LeafUser) = userService.add(user)

    @Put
    open fun update(@Body user: LeafUser) = userService.update(user)

    @Delete("/{ids}")
    open fun delete(@PathVariable("ids") ids: List<Long>) = userService.delete(ids)
}