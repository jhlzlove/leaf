package com.leaf.domain;

import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = LeafDept.class
)
public class LeafDeptTable extends AbstractTypedTable<LeafDept> implements LeafDeptProps {
    public static final LeafDeptTable $ = new LeafDeptTable();

    public LeafDeptTable() {
        super(LeafDept.class);
    }

    public LeafDeptTable(AbstractTypedTable.DelayedOperation<LeafDept> delayedOperation) {
        super(LeafDept.class, delayedOperation);
    }

    public LeafDeptTable(TableImplementor<LeafDept> table) {
        super(table);
    }

    protected LeafDeptTable(LeafDeptTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> deptId() {
        return __get(LeafDeptProps.DEPT_ID.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDateTime> createTime() {
        return __get(LeafDeptProps.CREATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDateTime> updateTime() {
        return __get(LeafDeptProps.UPDATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Str createBy() {
        return __get(LeafDeptProps.CREATE_BY.unwrap());
    }

    @Override
    public PropExpression.Str updateBy() {
        return __get(LeafDeptProps.UPDATE_BY.unwrap());
    }

    @Override
    public PropExpression.Str remark() {
        return __get(LeafDeptProps.REMARK.unwrap());
    }

    @Override
    public PropExpression.Str deptName() {
        return __get(LeafDeptProps.DEPT_NAME.unwrap());
    }

    @Override
    public PropExpression.Num<Long> parentId() {
        return __get(LeafDeptProps.PARENT_ID.unwrap());
    }

    @Override
    public PropExpression.Str deptCode() {
        return __get(LeafDeptProps.DEPT_CODE.unwrap());
    }

    @Override
    public PropExpression.Num<Long> leaderId() {
        return __get(LeafDeptProps.LEADER_ID.unwrap());
    }

    @Override
    public PropExpression.Str description() {
        return __get(LeafDeptProps.DESCRIPTION.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> status() {
        return __get(LeafDeptProps.STATUS.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> sortable() {
        return __get(LeafDeptProps.SORTABLE.unwrap());
    }

    @Override
    public PropExpression.Num<Long> roleId() {
        return __get(LeafDeptProps.ROLE_ID.unwrap());
    }

    @Override
    public Predicate userList(Function<LeafUserTableEx, Predicate> block) {
        return exists(LeafDeptProps.USER_LIST.unwrap(), block);
    }

    @Override
    public LeafDeptTableEx asTableEx() {
        return new LeafDeptTableEx(this, null);
    }

    @Override
    public LeafDeptTable __disableJoin(String reason) {
        return new LeafDeptTable(this, reason);
    }

    public static class Remote extends AbstractTypedTable<LeafDept> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(LeafDept.class, delayedOperation);
        }

        public Remote(TableImplementor<LeafDept> table) {
            super(table);
        }

        public PropExpression.Num<Long> deptId() {
            return __get(LeafDeptProps.DEPT_ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<LeafDept> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
