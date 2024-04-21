package com.leaf.domain;

import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
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
    public PropExpression.Str phone() {
        return __get(LeafUserProps.PHONE.unwrap());
    }

    @Override
    public PropExpression.Str email() {
        return __get(LeafUserProps.EMAIL.unwrap());
    }

    @Override
    public PropExpression.Str avatar() {
        return __get(LeafUserProps.AVATAR.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDate> lastLoginTime() {
        return __get(LeafUserProps.LAST_LOGIN_TIME.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> status() {
        return __get(LeafUserProps.STATUS.unwrap());
    }

    @Override
    public LeafUserDetailTable userDetail() {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserDetailTable(raw.joinImplementor(LeafUserProps.USER_DETAIL.unwrap()));
        }
        return new LeafUserDetailTable(joinOperation(LeafUserProps.USER_DETAIL.unwrap()));
    }

    @Override
    public LeafUserDetailTable userDetail(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new LeafUserDetailTable(raw.joinImplementor(LeafUserProps.USER_DETAIL.unwrap(), joinType));
        }
        return new LeafUserDetailTable(joinOperation(LeafUserProps.USER_DETAIL.unwrap(), joinType));
    }

    @Override
    public PropExpression.Num<Long> userDetailId() {
        return __getAssociatedId(LeafUserProps.USER_DETAIL.unwrap());
    }

    @Override
    public Predicate deptList(Function<LeafDeptTableEx, Predicate> block) {
        return exists(LeafUserProps.DEPT_LIST.unwrap(), block);
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
