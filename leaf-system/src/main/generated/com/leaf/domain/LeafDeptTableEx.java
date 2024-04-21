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
        type = LeafDept.class
)
public class LeafDeptTableEx extends LeafDeptTable implements TableEx<LeafDept> {
    public static final LeafDeptTableEx $ = new LeafDeptTableEx(LeafDeptTable.$, null);

    public LeafDeptTableEx() {
        super();
    }

    public LeafDeptTableEx(AbstractTypedTable.DelayedOperation<LeafDept> delayedOperation) {
        super(delayedOperation);
    }

    public LeafDeptTableEx(TableImplementor<LeafDept> table) {
        super(table);
    }

    protected LeafDeptTableEx(LeafDeptTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    public LeafUserTableEx userList() {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafDeptProps.USER_LIST.unwrap()));
        }
        return new LeafUserTableEx(joinOperation(LeafDeptProps.USER_LIST.unwrap()));
    }

    public LeafUserTableEx userList(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserTableEx(raw.joinImplementor(LeafDeptProps.USER_LIST.unwrap(), joinType));
        }
        return new LeafUserTableEx(joinOperation(LeafDeptProps.USER_LIST.unwrap(), joinType));
    }

    @Override
    public Predicate userList(Function<LeafUserTableEx, Predicate> block) {
        return exists(LeafDeptProps.USER_LIST.unwrap(), block);
    }

    @Override
    public LeafDeptTableEx asTableEx() {
        return this;
    }

    @Override
    public LeafDeptTableEx __disableJoin(String reason) {
        return new LeafDeptTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<LeafDeptTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("unchecked")
    public <TT extends Table<?>, WJ extends WeakJoin<LeafDeptTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
