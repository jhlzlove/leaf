package com.jhlz.service

import com.jhlz.domain.LeafDict
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
class LeafDictService(val sqlClient: KSqlClient) {
    fun page(pageQuery: PageQuery): Page<LeafDict> {
        return sqlClient.createQuery(LeafDict::class) {
            select(
                table.fetchBy {
                    allScalarFields()
                    creator { username() }
                }
            )
        }.fetchPage(pageQuery.pageNum - 1, pageQuery.pageSize)
    }

    fun info(id: Long): LeafDict {
        return sqlClient.findById(LeafDict::class, id)!!
    }

    fun add(dict: LeafDict) {
        sqlClient.entities.save(dict)
        throw Exception("test")

    }

    fun update(dict: LeafDict) {
        sqlClient.entities.save(dict)
    }

    fun delete(ids: List<Long>) {
        sqlClient.deleteByIds(LeafDict::class, ids)
    }
}