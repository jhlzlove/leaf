package com.leaf.domain;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.impl.table.TableProxies;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.WeakJoin;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = LeafUserDetail.class
)
public class LeafUserDetailTableEx extends LeafUserDetailTable implements TableEx<LeafUserDetail> {
    public static final LeafUserDetailTableEx $ = new LeafUserDetailTableEx(LeafUserDetailTable.$, null);

    public LeafUserDetailTableEx() {
        super();
    }

    public LeafUserDetailTableEx(
            AbstractTypedTable.DelayedOperation<LeafUserDetail> delayedOperation) {
        super(delayedOperation);
    }

    public LeafUserDetailTableEx(TableImplementor<LeafUserDetail> table) {
        super(table);
    }

    protected LeafUserDetailTableEx(LeafUserDetailTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    public LeafUserTableEx users() {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafUserDetailProps.USERS.unwrap()));
        }
        return new LeafUserTableEx(joinOperation(LeafUserDetailProps.USERS.unwrap()));
    }

    public LeafUserTableEx users(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafUserDetailProps.USERS.unwrap(), joinType));
        }
        return new LeafUserTableEx(joinOperation(LeafUserDetailProps.USERS.unwrap(), joinType));
    }

    @Override
    public Predicate users(Function<LeafUserTableEx, Predicate> block) {
        return exists(LeafUserDetailProps.USERS.unwrap(), block);
    }

    @Override
    public LeafUserDetailTableEx asTableEx() {
        return this;
    }

    @Override
    public LeafUserDetailTableEx __disableJoin(String reason) {
        return new LeafUserDetailTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<LeafUserDetailTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("unchecked")
    public <TT extends Table<?>, WJ extends WeakJoin<LeafUserDetailTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
