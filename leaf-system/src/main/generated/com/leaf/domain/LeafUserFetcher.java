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
        type = LeafUser.class
)
public class LeafUserFetcher extends AbstractTypedFetcher<LeafUser, LeafUserFetcher> {
    public static final LeafUserFetcher $ = new LeafUserFetcher(null);

    private LeafUserFetcher(FetcherImpl<LeafUser> base) {
        super(LeafUser.class, base);
    }

    private LeafUserFetcher(LeafUserFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private LeafUserFetcher(LeafUserFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static LeafUserFetcher $from(Fetcher<LeafUser> base) {
        return base instanceof LeafUserFetcher ? 
        	(LeafUserFetcher)base : 
        	new LeafUserFetcher((FetcherImpl<LeafUser>)base);
    }

    @NewChain
    public LeafUserFetcher createTime() {
        return add("createTime");
    }

    @NewChain
    public LeafUserFetcher createTime(boolean enabled) {
        return enabled ? add("createTime") : remove("createTime");
    }

    @NewChain
    public LeafUserFetcher updateTime() {
        return add("updateTime");
    }

    @NewChain
    public LeafUserFetcher updateTime(boolean enabled) {
        return enabled ? add("updateTime") : remove("updateTime");
    }

    @NewChain
    public LeafUserFetcher createBy() {
        return add("createBy");
    }

    @NewChain
    public LeafUserFetcher createBy(boolean enabled) {
        return enabled ? add("createBy") : remove("createBy");
    }

    @NewChain
    public LeafUserFetcher updateBy() {
        return add("updateBy");
    }

    @NewChain
    public LeafUserFetcher updateBy(boolean enabled) {
        return enabled ? add("updateBy") : remove("updateBy");
    }

    @NewChain
    public LeafUserFetcher remark() {
        return add("remark");
    }

    @NewChain
    public LeafUserFetcher remark(boolean enabled) {
        return enabled ? add("remark") : remove("remark");
    }

    @NewChain
    public LeafUserFetcher username() {
        return add("username");
    }

    @NewChain
    public LeafUserFetcher username(boolean enabled) {
        return enabled ? add("username") : remove("username");
    }

    @NewChain
    public LeafUserFetcher password() {
        return add("password");
    }

    @NewChain
    public LeafUserFetcher password(boolean enabled) {
        return enabled ? add("password") : remove("password");
    }

    @NewChain
    public LeafUserFetcher nickName() {
        return add("nickName");
    }

    @NewChain
    public LeafUserFetcher nickName(boolean enabled) {
        return enabled ? add("nickName") : remove("nickName");
    }

    @NewChain
    public LeafUserFetcher phone() {
        return add("phone");
    }

    @NewChain
    public LeafUserFetcher phone(boolean enabled) {
        return enabled ? add("phone") : remove("phone");
    }

    @NewChain
    public LeafUserFetcher email() {
        return add("email");
    }

    @NewChain
    public LeafUserFetcher email(boolean enabled) {
        return enabled ? add("email") : remove("email");
    }

    @NewChain
    public LeafUserFetcher avatar() {
        return add("avatar");
    }

    @NewChain
    public LeafUserFetcher avatar(boolean enabled) {
        return enabled ? add("avatar") : remove("avatar");
    }

    @NewChain
    public LeafUserFetcher lastLoginTime() {
        return add("lastLoginTime");
    }

    @NewChain
    public LeafUserFetcher lastLoginTime(boolean enabled) {
        return enabled ? add("lastLoginTime") : remove("lastLoginTime");
    }

    @NewChain
    public LeafUserFetcher status() {
        return add("status");
    }

    @NewChain
    public LeafUserFetcher status(boolean enabled) {
        return enabled ? add("status") : remove("status");
    }

    @NewChain
    public LeafUserFetcher userDetailId() {
        return add("userDetailId");
    }

    @NewChain
    public LeafUserFetcher userDetailId(boolean enabled) {
        return enabled ? add("userDetailId") : remove("userDetailId");
    }

    @NewChain
    public LeafUserFetcher userDetailId(IdOnlyFetchType idOnlyFetchType) {
        return add("userDetailId", idOnlyFetchType);
    }

    @NewChain
    public LeafUserFetcher userDetail() {
        return add("userDetail");
    }

    @NewChain
    public LeafUserFetcher userDetail(boolean enabled) {
        return enabled ? add("userDetail") : remove("userDetail");
    }

    @NewChain
    public LeafUserFetcher userDetail(Fetcher<LeafUserDetail> childFetcher) {
        return add("userDetail", childFetcher);
    }

    @NewChain
    public LeafUserFetcher userDetail(Fetcher<LeafUserDetail> childFetcher,
            Consumer<FieldConfig<LeafUserDetail, LeafUserDetailTable>> fieldConfig) {
        return add("userDetail", childFetcher, fieldConfig);
    }

    @NewChain
    public LeafUserFetcher userDetail(IdOnlyFetchType idOnlyFetchType) {
        return add("userDetail", idOnlyFetchType);
    }

    @NewChain
    public LeafUserFetcher deptList() {
        return add("deptList");
    }

    @NewChain
    public LeafUserFetcher deptList(boolean enabled) {
        return enabled ? add("deptList") : remove("deptList");
    }

    @NewChain
    public LeafUserFetcher deptList(Fetcher<LeafDept> childFetcher) {
        return add("deptList", childFetcher);
    }

    @NewChain
    public LeafUserFetcher deptList(Fetcher<LeafDept> childFetcher,
            Consumer<ListFieldConfig<LeafDept, LeafDeptTable>> fieldConfig) {
        return add("deptList", childFetcher, fieldConfig);
    }

    @NewChain
    public LeafUserFetcher deptList(IdOnlyFetchType idOnlyFetchType) {
        return add("deptList", idOnlyFetchType);
    }

    @Override
    protected LeafUserFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new LeafUserFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected LeafUserFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new LeafUserFetcher(this, prop, fieldConfig);
    }
}
