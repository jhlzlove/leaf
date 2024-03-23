package com.leaf.domain;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.impl.table.TableProxies;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.WeakJoin;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = LeafUser.class
)
public class LeafUserTableEx extends LeafUserTable implements TableEx<LeafUser> {
    public static final LeafUserTableEx $ = new LeafUserTableEx(LeafUserTable.$, null);

    public LeafUserTableEx() {
        super();
    }

    public LeafUserTableEx(AbstractTypedTable.DelayedOperation<LeafUser> delayedOperation) {
        super(delayedOperation);
    }

    public LeafUserTableEx(TableImplementor<LeafUser> table) {
        super(table);
    }

    protected LeafUserTableEx(LeafUserTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public LeafUserTableEx asTableEx() {
        return this;
    }

    @Override
    public LeafUserTableEx __disableJoin(String reason) {
        return new LeafUserTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<LeafUserTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("unchecked")
    public <TT extends Table<?>, WJ extends WeakJoin<LeafUserTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
