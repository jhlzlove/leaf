package com.leaf.common.interceptor;

import com.leaf.domain.*;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.sql.DraftInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Jimmer 拦截器完成审计功能
 * Jimmer Spring Boot Starter 使用 @Component 注解即可
 *
 * @author jhlz
 * @version x.x.x
 */
@Component
public class AuditInterceptor implements DraftInterceptor<BaseEntity, BaseEntityDraft> {
    @Override
    public void beforeSave(@NotNull BaseEntityDraft draft, @Nullable BaseEntity baseEntity) {
        if (!ImmutableObjects.isLoaded(draft, BaseEntityProps.UPDATE_TIME)) {
            draft.setUpdateTime(LocalDateTime.now());
        }
        if (draft instanceof LeafUserDraft && !ImmutableObjects.isLoaded(draft, LeafUserProps.LAST_LOGIN_TIME)) {
            ((LeafUserDraft) draft).setLastLoginTime(LocalDateTime.now());
        }
    }
}
