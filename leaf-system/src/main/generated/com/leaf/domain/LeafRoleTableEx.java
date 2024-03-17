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
        type = LeafRole.class
)
public class LeafRoleTableEx extends LeafRoleTable implements TableEx<LeafRole> {
    public static final LeafRoleTableEx $ = new LeafRoleTableEx(LeafRoleTable.$, null);

    public LeafRoleTableEx() {
        super();
    }

    public LeafRoleTableEx(AbstractTypedTable.DelayedOperation<LeafRole> delayedOperation) {
        super(delayedOperation);
    }

    public LeafRoleTableEx(TableImplementor<LeafRole> table) {
        super(table);
    }

    protected LeafRoleTableEx(LeafRoleTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    public LeafUserTableEx createBy() {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafRoleProps.CREATE_BY.unwrap()));
        }
        return new LeafUserTableEx(joinOperation(LeafRoleProps.CREATE_BY.unwrap()));
    }

    public LeafUserTableEx createBy(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafRoleProps.CREATE_BY.unwrap(), joinType));
        }
        return new LeafUserTableEx(joinOperation(LeafRoleProps.CREATE_BY.unwrap(), joinType));
    }

    public LeafUserTableEx updateBy() {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafRoleProps.UPDATE_BY.unwrap()));
        }
        return new LeafUserTableEx(joinOperation(LeafRoleProps.UPDATE_BY.unwrap()));
    }

    public LeafUserTableEx updateBy(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafRoleProps.UPDATE_BY.unwrap(), joinType));
        }
        return new LeafUserTableEx(joinOperation(LeafRoleProps.UPDATE_BY.unwrap(), joinType));
    }

    @Override
    public LeafRoleTableEx asTableEx() {
        return this;
    }

    @Override
    public LeafRoleTableEx __disableJoin(String reason) {
        return new LeafRoleTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<LeafRoleTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("unchecked")
    public <TT extends Table<?>, WJ extends WeakJoin<LeafRoleTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
