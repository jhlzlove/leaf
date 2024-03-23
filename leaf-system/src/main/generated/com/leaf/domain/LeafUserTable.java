package com.leaf.domain;

import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = LeafUser.class
)
public class LeafUserTable extends AbstractTypedTable<LeafUser> implements LeafUserProps {
    public static final LeafUserTable $ = new LeafUserTable();

    public LeafUserTable() {
        super(LeafUser.class);
    }

    public LeafUserTable(AbstractTypedTable.DelayedOperation<LeafUser> delayedOperation) {
        super(LeafUser.class, delayedOperation);
    }

    public LeafUserTable(TableImplementor<LeafUser> table) {
        super(table);
    }

    protected LeafUserTable(LeafUserTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> userId() {
        return __get(LeafUserProps.USER_ID.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDateTime> createTime() {
        return __get(LeafUserProps.CREATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDateTime> updateTime() {
        return __get(LeafUserProps.UPDATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Str createBy() {
        return __get(LeafUserProps.CREATE_BY.unwrap());
    }

    @Override
    public PropExpression.Str updateBy() {
        return __get(LeafUserProps.UPDATE_BY.unwrap());
    }

    @Override
    public PropExpression.Str remark() {
        return __get(LeafUserProps.REMARK.unwrap());
    }

    @Override
    public PropExpression.Str username() {
        return __get(LeafUserProps.USERNAME.unwrap());
    }

    @Override
    public PropExpression.Str password() {
        return __get(LeafUserProps.PASSWORD.unwrap());
    }

    @Override
    public PropExpression.Str nickName() {
        return __get(LeafUserProps.NICK_NAME.unwrap());
    }

    @Override
    public PropExpression.Str avatar() {
        return __get(LeafUserProps.AVATAR.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> status() {
        return __get(LeafUserProps.STATUS.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> delFlag() {
        return __get(LeafUserProps.DEL_FLAG.unwrap());
    }

    @Override
    public PropExpression.Str userCode() {
        return __get(LeafUserProps.USER_CODE.unwrap());
    }

    @Override
    public LeafUserTableEx asTableEx() {
        return new LeafUserTableEx(this, null);
    }

    @Override
    public LeafUserTable __disableJoin(String reason) {
        return new LeafUserTable(this, reason);
    }

    public static class Remote extends AbstractTypedTable<LeafUser> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(LeafUser.class, delayedOperation);
        }

        public Remote(TableImplementor<LeafUser> table) {
            super(table);
        }

        public PropExpression.Num<Long> userId() {
            return __get(LeafUserProps.USER_ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<LeafUser> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
