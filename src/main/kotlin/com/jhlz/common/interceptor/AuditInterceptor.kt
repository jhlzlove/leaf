package com.jhlz.common.interceptor

import com.jhlz.domain.BaseEntity
import com.jhlz.domain.BaseEntityDraft
import com.jhlz.domain.BaseEntityProps
import jakarta.enterprise.context.ApplicationScoped
import org.babyfish.jimmer.ImmutableObjects
import org.babyfish.jimmer.sql.DraftInterceptor
import java.time.LocalDateTime

/**
 * Jimmer 拦截器完成审计功能
 *
 * @author jhlz
 * @version 1.0.0
 */
@ApplicationScoped
class AuditInterceptor : DraftInterceptor<BaseEntity, BaseEntityDraft> {
    override fun beforeSave(draft: BaseEntityDraft, baseEntity: BaseEntity?) {
        if (!ImmutableObjects.isLoaded(draft, BaseEntityProps.UPDATE_TIME)) {
            draft.updateTime = LocalDateTime.now()
        }
    }
}
