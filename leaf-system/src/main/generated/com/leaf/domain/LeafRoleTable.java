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
        type = LeafRole.class
)
public class LeafRoleTable extends AbstractTypedTable<LeafRole> implements LeafRoleProps {
    public static final LeafRoleTable $ = new LeafRoleTable();

    public LeafRoleTable() {
        super(LeafRole.class);
    }

    public LeafRoleTable(AbstractTypedTable.DelayedOperation<LeafRole> delayedOperation) {
        super(LeafRole.class, delayedOperation);
    }

    public LeafRoleTable(TableImplementor<LeafRole> table) {
        super(table);
    }

    protected LeafRoleTable(LeafRoleTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> roleId() {
        return __get(LeafRoleProps.ROLE_ID.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDateTime> createTime() {
        return __get(LeafRoleProps.CREATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Cmp<LocalDateTime> updateTime() {
        return __get(LeafRoleProps.UPDATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Str createBy() {
        return __get(LeafRoleProps.CREATE_BY.unwrap());
    }

    @Override
    public PropExpression.Str updateBy() {
        return __get(LeafRoleProps.UPDATE_BY.unwrap());
    }

    @Override
    public PropExpression.Str remark() {
        return __get(LeafRoleProps.REMARK.unwrap());
    }

    @Override
    public PropExpression.Str roleCode() {
        return __get(LeafRoleProps.ROLE_CODE.unwrap());
    }

    @Override
    public PropExpression.Str pCode() {
        return __get(LeafRoleProps.P_CODE.unwrap());
    }

    @Override
    public PropExpression.Str roleName() {
        return __get(LeafRoleProps.ROLE_NAME.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> status() {
        return __get(LeafRoleProps.STATUS.unwrap());
    }

    @Override
    public LeafRoleTableEx asTableEx() {
        return new LeafRoleTableEx(this, null);
    }

    @Override
    public LeafRoleTable __disableJoin(String reason) {
        return new LeafRoleTable(this, reason);
    }

    public static class Remote extends AbstractTypedTable<LeafRole> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(LeafRole.class, delayedOperation);
        }

        public Remote(TableImplementor<LeafRole> table) {
            super(table);
        }

        public PropExpression.Num<Long> roleId() {
            return __get(LeafRoleProps.ROLE_ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<LeafRole> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
