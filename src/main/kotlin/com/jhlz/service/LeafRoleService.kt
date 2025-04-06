package com.jhlz.service

import com.jhlz.domain.LeafRole
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
class LeafRoleService (val sqlClient: KSqlClient){
    fun page(pageQuery: PageQuery): Page<LeafRole> {
        return sqlClient.createQuery(LeafRole::class) {
            select(
                table.fetchBy {
                    allScalarFields()
                    creator { username() }
                }
            )
        }.fetchPage(pageQuery.pageNum - 1, pageQuery.pageSize)
    }

    fun info(id: Long): LeafRole {
        return sqlClient.findById(LeafRole::class, id)!!
    }

    fun add(role: LeafRole) {
        sqlClient.entities.save(role)
        throw Exception("test")

    }

    fun update(role: LeafRole) {
        sqlClient.entities.save(role)
    }

    fun delete(ids: List<Long>) {
        sqlClient.deleteByIds(LeafRole::class, ids)
    }
}