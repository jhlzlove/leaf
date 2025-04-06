package com.jhlz.service

import com.jhlz.domain.LeafUser
import com.jhlz.domain.fetchBy
import com.jhlz.record.PageQuery
import jakarta.inject.Singleton
import org.babyfish.jimmer.Page
import org.babyfish.jimmer.sql.kt.KSqlClient

/**
 * @author jhlz
 * @version x.x.x
 */
@Singleton
class LeafUserService(val sqlClient: KSqlClient) {

    fun page(pageQuery: PageQuery): Page<LeafUser> {

        return sqlClient.createQuery(LeafUser::class) {
            select(
                table.fetchBy {
                    allScalarFields()
                    creator { username() }
                }
            )
        }.fetchPage(pageQuery.pageNum - 1, pageQuery.pageSize)
    }

    fun info(id: Long): LeafUser {
        return sqlClient.findById(LeafUser::class, id)!!
    }

    fun add(user: LeafUser) {
        sqlClient.save(user)
    }

    fun update(user: LeafUser) {
        sqlClient.save(user)
    }

    fun delete(ids: List<Long>) {
        sqlClient.deleteByIds(LeafUser::class, ids)
    }




}