package com.leaf.domain;

import java.lang.Override;
import java.util.function.Consumer;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.ListFieldConfig;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = LeafDept.class
)
public class LeafDeptFetcher extends AbstractTypedFetcher<LeafDept, LeafDeptFetcher> {
    public static final LeafDeptFetcher $ = new LeafDeptFetcher(null);

    private LeafDeptFetcher(FetcherImpl<LeafDept> base) {
        super(LeafDept.class, base);
    }

    private LeafDeptFetcher(LeafDeptFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private LeafDeptFetcher(LeafDeptFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static LeafDeptFetcher $from(Fetcher<LeafDept> base) {
        return base instanceof LeafDeptFetcher ? 
        	(LeafDeptFetcher)base : 
        	new LeafDeptFetcher((FetcherImpl<LeafDept>)base);
    }

    @NewChain
    public LeafDeptFetcher createTime() {
        return add("createTime");
    }

    @NewChain
    public LeafDeptFetcher createTime(boolean enabled) {
        return enabled ? add("createTime") : remove("createTime");
    }

    @NewChain
    public LeafDeptFetcher updateTime() {
        return add("updateTime");
    }

    @NewChain
    public LeafDeptFetcher updateTime(boolean enabled) {
        return enabled ? add("updateTime") : remove("updateTime");
    }

    @NewChain
    public LeafDeptFetcher createBy() {
        return add("createBy");
    }

    @NewChain
    public LeafDeptFetcher createBy(boolean enabled) {
        return enabled ? add("createBy") : remove("createBy");
    }

    @NewChain
    public LeafDeptFetcher updateBy() {
        return add("updateBy");
    }

    @NewChain
    public LeafDeptFetcher updateBy(boolean enabled) {
        return enabled ? add("updateBy") : remove("updateBy");
    }

    @NewChain
    public LeafDeptFetcher remark() {
        return add("remark");
    }

    @NewChain
    public LeafDeptFetcher remark(boolean enabled) {
        return enabled ? add("remark") : remove("remark");
    }

    @NewChain
    public LeafDeptFetcher deptName() {
        return add("deptName");
    }

    @NewChain
    public LeafDeptFetcher deptName(boolean enabled) {
        return enabled ? add("deptName") : remove("deptName");
    }

    @NewChain
    public LeafDeptFetcher parentId() {
        return add("parentId");
    }

    @NewChain
    public LeafDeptFetcher parentId(boolean enabled) {
        return enabled ? add("parentId") : remove("parentId");
    }

    @NewChain
    public LeafDeptFetcher deptCode() {
        return add("deptCode");
    }

    @NewChain
    public LeafDeptFetcher deptCode(boolean enabled) {
        return enabled ? add("deptCode") : remove("deptCode");
    }

    @NewChain
    public LeafDeptFetcher leaderId() {
        return add("leaderId");
    }

    @NewChain
    public LeafDeptFetcher leaderId(boolean enabled) {
        return enabled ? add("leaderId") : remove("leaderId");
    }

    @NewChain
    public LeafDeptFetcher description() {
        return add("description");
    }

    @NewChain
    public LeafDeptFetcher description(boolean enabled) {
        return enabled ? add("description") : remove("description");
    }

    @NewChain
    public LeafDeptFetcher status() {
        return add("status");
    }

    @NewChain
    public LeafDeptFetcher status(boolean enabled) {
        return enabled ? add("status") : remove("status");
    }

    @NewChain
    public LeafDeptFetcher sortable() {
        return add("sortable");
    }

    @NewChain
    public LeafDeptFetcher sortable(boolean enabled) {
        return enabled ? add("sortable") : remove("sortable");
    }

    @NewChain
    public LeafDeptFetcher roleId() {
        return add("roleId");
    }

    @NewChain
    public LeafDeptFetcher roleId(boolean enabled) {
        return enabled ? add("roleId") : remove("roleId");
    }

    @NewChain
    public LeafDeptFetcher userList() {
        return add("userList");
    }

    @NewChain
    public LeafDeptFetcher userList(boolean enabled) {
        return enabled ? add("userList") : remove("userList");
    }

    @NewChain
    public LeafDeptFetcher userList(Fetcher<LeafUser> childFetcher) {
        return add("userList", childFetcher);
    }

    @NewChain
    public LeafDeptFetcher userList(Fetcher<LeafUser> childFetcher,
            Consumer<ListFieldConfig<LeafUser, LeafUserTable>> fieldConfig) {
        return add("userList", childFetcher, fieldConfig);
    }

    @NewChain
    public LeafDeptFetcher userList(IdOnlyFetchType idOnlyFetchType) {
        return add("userList", idOnlyFetchType);
    }

    @Override
    protected LeafDeptFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new LeafDeptFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected LeafDeptFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new LeafDeptFetcher(this, prop, fieldConfig);
    }
}
