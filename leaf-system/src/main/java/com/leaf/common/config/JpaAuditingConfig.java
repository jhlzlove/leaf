package com.leaf.common.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 配置 Jpa 审计功能，自动设置 createBy、updateBy 等字段
 *
 * @author jhlz
 * @since 2023/2/16 14:00
 */
@Component
@EnableJpaAuditing
public class JpaAuditingConfig implements AuditorAware<String> {
    
    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        // String username = SecurityUtil.getLoginUser().getUsername();
        return Optional.of("admin");
    }
}
