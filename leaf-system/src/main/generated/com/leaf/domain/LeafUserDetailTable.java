package com.leaf.domain;

import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = LeafUserDetail.class
)
public class LeafUserDetailTable extends AbstractTypedTable<LeafUserDetail> implements LeafUserDetailProps {
    public static final LeafUserDetailTable $ = new LeafUserDetailTable();

    public LeafUserDetailTable() {
        super(LeafUserDetail.class);
    }

    public LeafUserDetailTable(
            AbstractTypedTable.DelayedOperation<LeafUserDetail> delayedOperation) {
        super(LeafUserDetail.class, delayedOperation);
    }

    public LeafUserDetailTable(TableImplementor<LeafUserDetail> table) {
        super(table);
    }

    protected LeafUserDetailTable(LeafUserDetailTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> userDetailId() {
        return __get(LeafUserDetailProps.USER_DETAIL_ID.unwrap());
    }

    @Override
    public PropExpression.Str firstName() {
        return __get(LeafUserDetailProps.FIRST_NAME.unwrap());
    }

    @Override
    public PropExpression.Str lastName() {
        return __get(LeafUserDetailProps.LAST_NAME.unwrap());
    }

    @Override
    public PropExpression.Str ethnic() {
        return __get(LeafUserDetailProps.ETHNIC.unwrap());
    }

    @Override
    public PropExpression.Str gender() {
        return __get(LeafUserDetailProps.GENDER.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> age() {
        return __get(LeafUserDetailProps.AGE.unwrap());
    }

    @Override
    public PropExpression.Str address() {
        return __get(LeafUserDetailProps.ADDRESS.unwrap());
    }

    @Override
    public PropExpression.Str hometown() {
        return __get(LeafUserDetailProps.HOMETOWN.unwrap());
    }

    @Override
    public PropExpression.Str idCard() {
        return __get(LeafUserDetailProps.ID_CARD.unwrap());
    }

    @Override
    public Predicate users(Function<LeafUserTableEx, Predicate> block) {
        return exists(LeafUserDetailProps.USERS.unwrap(), block);
    }

    @Override
    public LeafUserDetailTableEx asTableEx() {
        return new LeafUserDetailTableEx(this, null);
    }

    @Override
    public LeafUserDetailTable __disableJoin(String reason) {
        return new LeafUserDetailTable(this, reason);
    }

    public static class Remote extends AbstractTypedTable<LeafUserDetail> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(LeafUserDetail.class, delayedOperation);
        }

        public Remote(TableImplementor<LeafUserDetail> table) {
            super(table);
        }

        public PropExpression.Num<Long> userDetailId() {
            return __get(LeafUserDetailProps.USER_DETAIL_ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<LeafUserDetail> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
