package com.leaf.system.common.interceptor;

import com.leaf.system.domain.BaseEntity;
import com.leaf.system.domain.BaseEntityDraft;
import com.leaf.system.domain.BaseEntityProps;
import jakarta.enterprise.context.ApplicationScoped;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.sql.DraftInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * Jimmer 拦截器完成审计功能
 *
 * @author jhlz
 * @version 1.0.0
 */
@ApplicationScoped
public class AuditInterceptor implements DraftInterceptor<BaseEntity, BaseEntityDraft> {
    @Override
    public void beforeSave(@NotNull BaseEntityDraft draft, @Nullable BaseEntity baseEntity) {
        if (!ImmutableObjects.isLoaded(draft, BaseEntityProps.UPDATE_TIME)) {
            draft.setUpdateTime(LocalDateTime.now());
        }

    }
}
