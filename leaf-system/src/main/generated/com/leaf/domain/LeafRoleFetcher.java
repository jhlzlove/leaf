package com.leaf.domain;

import java.lang.Override;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = LeafRole.class
)
public class LeafRoleFetcher extends AbstractTypedFetcher<LeafRole, LeafRoleFetcher> {
    public static final LeafRoleFetcher $ = new LeafRoleFetcher(null);

    private LeafRoleFetcher(FetcherImpl<LeafRole> base) {
        super(LeafRole.class, base);
    }

    private LeafRoleFetcher(LeafRoleFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private LeafRoleFetcher(LeafRoleFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static LeafRoleFetcher $from(Fetcher<LeafRole> base) {
        return base instanceof LeafRoleFetcher ? 
        	(LeafRoleFetcher)base : 
        	new LeafRoleFetcher((FetcherImpl<LeafRole>)base);
    }

    @NewChain
    public LeafRoleFetcher createTime() {
        return add("createTime");
    }

    @NewChain
    public LeafRoleFetcher createTime(boolean enabled) {
        return enabled ? add("createTime") : remove("createTime");
    }

    @NewChain
    public LeafRoleFetcher updateTime() {
        return add("updateTime");
    }

    @NewChain
    public LeafRoleFetcher updateTime(boolean enabled) {
        return enabled ? add("updateTime") : remove("updateTime");
    }

    @NewChain
    public LeafRoleFetcher createBy() {
        return add("createBy");
    }

    @NewChain
    public LeafRoleFetcher createBy(boolean enabled) {
        return enabled ? add("createBy") : remove("createBy");
    }

    @NewChain
    public LeafRoleFetcher updateBy() {
        return add("updateBy");
    }

    @NewChain
    public LeafRoleFetcher updateBy(boolean enabled) {
        return enabled ? add("updateBy") : remove("updateBy");
    }

    @NewChain
    public LeafRoleFetcher remark() {
        return add("remark");
    }

    @NewChain
    public LeafRoleFetcher remark(boolean enabled) {
        return enabled ? add("remark") : remove("remark");
    }

    @NewChain
    public LeafRoleFetcher roleCode() {
        return add("roleCode");
    }

    @NewChain
    public LeafRoleFetcher roleCode(boolean enabled) {
        return enabled ? add("roleCode") : remove("roleCode");
    }

    @NewChain
    public LeafRoleFetcher pCode() {
        return add("pCode");
    }

    @NewChain
    public LeafRoleFetcher pCode(boolean enabled) {
        return enabled ? add("pCode") : remove("pCode");
    }

    @NewChain
    public LeafRoleFetcher roleName() {
        return add("roleName");
    }

    @NewChain
    public LeafRoleFetcher roleName(boolean enabled) {
        return enabled ? add("roleName") : remove("roleName");
    }

    @NewChain
    public LeafRoleFetcher status() {
        return add("status");
    }

    @NewChain
    public LeafRoleFetcher status(boolean enabled) {
        return enabled ? add("status") : remove("status");
    }

    @Override
    protected LeafRoleFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new LeafRoleFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected LeafRoleFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new LeafRoleFetcher(this, prop, fieldConfig);
    }
}
