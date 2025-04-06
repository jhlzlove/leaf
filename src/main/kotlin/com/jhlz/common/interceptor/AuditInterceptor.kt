package com.jhlz.common.interceptor

import com.jhlz.domain.BaseEntity
import com.jhlz.domain.BaseEntityDraft
import io.micronaut.context.annotation.Factory
import org.babyfish.jimmer.kt.isLoaded
import org.babyfish.jimmer.sql.DraftInterceptor
import java.time.OffsetDateTime

/**
 * Jimmer 拦截器完成审计功能
 *
 * DraftPreProcessor 与 DraftInterceptor 关键不同就是无法区分是否是插入还是删除操作
 * 可以说是 DraftInterceptor 的弱化版本，但是性能好，少了一次额外的查询
 * @author jhlz
 * @version 1.0.0
 */
@Factory
class AuditInterceptor : DraftInterceptor<BaseEntity, BaseEntityDraft> {

    override fun beforeSave(draft: BaseEntityDraft, original: BaseEntity?) {
        // 更新
        if (!isLoaded(draft, BaseEntity::updateTime)) {
            draft.updateTime = OffsetDateTime.now()
        }

        // if (!isLoaded(draft, BaseEntity::updator)) {
        //     draft.updator {
        //         id = 1
        //     }
        // }

        // 新增
        if (original === null) {
            if (!isLoaded(draft, BaseEntity::createTime)) {
                draft.createTime = OffsetDateTime.now()
            }

            // if (!isLoaded(draft, BaseEntity::creator)) {
            //     draft.creator() {
            //         id = 1
            //     }
            // }
        }
    }
}
