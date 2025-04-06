package com.jhlz.service

import com.jhlz.domain.LeafMenu
import com.jhlz.record.PageQuery
import jakarta.inject.Singleton
import org.babyfish.jimmer.Page
import org.babyfish.jimmer.sql.kt.KSqlClient

/**
 * @author jhlz
 * @version x.x.x
 */
@Singleton
class MenuService(val sqlClient: KSqlClient) {

    /**
     * 分页查询
     */
    fun page(page: PageQuery) : Page<LeafMenu> {
        // val page = PageQuery.create(pageQuery)
        return sqlClient.createQuery(LeafMenu::class) {
            select(table)
        }.fetchPage(page.pageNum, page.pageSize)
    }

    fun info(id: Long) = sqlClient.findById(LeafMenu::class, id)

    // @Transactional
    fun add(menu: LeafMenu) = sqlClient.insert(menu)

    // @Transactional
    fun edit(menu: LeafMenu) = sqlClient.save(menu)

    // @Transactional
    fun del(id: Long) = sqlClient.deleteById(LeafMenu::class, id)
}