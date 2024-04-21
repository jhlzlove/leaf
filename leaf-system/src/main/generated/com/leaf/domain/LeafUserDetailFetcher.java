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
        type = LeafUserDetail.class
)
public class LeafUserDetailFetcher extends AbstractTypedFetcher<LeafUserDetail, LeafUserDetailFetcher> {
    public static final LeafUserDetailFetcher $ = new LeafUserDetailFetcher(null);

    private LeafUserDetailFetcher(FetcherImpl<LeafUserDetail> base) {
        super(LeafUserDetail.class, base);
    }

    private LeafUserDetailFetcher(LeafUserDetailFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private LeafUserDetailFetcher(LeafUserDetailFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static LeafUserDetailFetcher $from(Fetcher<LeafUserDetail> base) {
        return base instanceof LeafUserDetailFetcher ? 
        	(LeafUserDetailFetcher)base : 
        	new LeafUserDetailFetcher((FetcherImpl<LeafUserDetail>)base);
    }

    @NewChain
    public LeafUserDetailFetcher firstName() {
        return add("firstName");
    }

    @NewChain
    public LeafUserDetailFetcher firstName(boolean enabled) {
        return enabled ? add("firstName") : remove("firstName");
    }

    @NewChain
    public LeafUserDetailFetcher lastName() {
        return add("lastName");
    }

    @NewChain
    public LeafUserDetailFetcher lastName(boolean enabled) {
        return enabled ? add("lastName") : remove("lastName");
    }

    @NewChain
    public LeafUserDetailFetcher ethnic() {
        return add("ethnic");
    }

    @NewChain
    public LeafUserDetailFetcher ethnic(boolean enabled) {
        return enabled ? add("ethnic") : remove("ethnic");
    }

    @NewChain
    public LeafUserDetailFetcher gender() {
        return add("gender");
    }

    @NewChain
    public LeafUserDetailFetcher gender(boolean enabled) {
        return enabled ? add("gender") : remove("gender");
    }

    @NewChain
    public LeafUserDetailFetcher age() {
        return add("age");
    }

    @NewChain
    public LeafUserDetailFetcher age(boolean enabled) {
        return enabled ? add("age") : remove("age");
    }

    @NewChain
    public LeafUserDetailFetcher address() {
        return add("address");
    }

    @NewChain
    public LeafUserDetailFetcher address(boolean enabled) {
        return enabled ? add("address") : remove("address");
    }

    @NewChain
    public LeafUserDetailFetcher hometown() {
        return add("hometown");
    }

    @NewChain
    public LeafUserDetailFetcher hometown(boolean enabled) {
        return enabled ? add("hometown") : remove("hometown");
    }

    @NewChain
    public LeafUserDetailFetcher idCard() {
        return add("idCard");
    }

    @NewChain
    public LeafUserDetailFetcher idCard(boolean enabled) {
        return enabled ? add("idCard") : remove("idCard");
    }

    @NewChain
    public LeafUserDetailFetcher users() {
        return add("users");
    }

    @NewChain
    public LeafUserDetailFetcher users(boolean enabled) {
        return enabled ? add("users") : remove("users");
    }

    @NewChain
    public LeafUserDetailFetcher users(Fetcher<LeafUser> childFetcher) {
        return add("users", childFetcher);
    }

    @NewChain
    public LeafUserDetailFetcher users(Fetcher<LeafUser> childFetcher,
            Consumer<ListFieldConfig<LeafUser, LeafUserTable>> fieldConfig) {
        return add("users", childFetcher, fieldConfig);
    }

    @Override
    protected LeafUserDetailFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new LeafUserDetailFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected LeafUserDetailFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new LeafUserDetailFetcher(this, prop, fieldConfig);
    }
}
