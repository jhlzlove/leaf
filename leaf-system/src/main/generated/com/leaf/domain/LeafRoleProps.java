package com.leaf.domain;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = LeafRole.class
)
@PropsFor(LeafRole.class)
public interface LeafRoleProps extends BaseEntityProps {
    TypedProp.Scalar<LeafRole, Long> ROLE_ID = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("roleId"));

    TypedProp.Scalar<LeafRole, LocalDateTime> CREATE_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("createTime"));

    TypedProp.Scalar<LeafRole, LocalDateTime> UPDATE_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("updateTime"));

    TypedProp.Scalar<LeafRole, String> CREATE_BY = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("createBy"));

    TypedProp.Scalar<LeafRole, String> UPDATE_BY = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("updateBy"));

    TypedProp.Scalar<LeafRole, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("remark"));

    TypedProp.Scalar<LeafRole, String> ROLE_CODE = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("roleCode"));

    TypedProp.Scalar<LeafRole, String> P_CODE = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("pCode"));

    TypedProp.Scalar<LeafRole, String> ROLE_NAME = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("roleName"));

    TypedProp.Scalar<LeafRole, Integer> STATUS = 
        TypedProp.scalar(ImmutableType.get(LeafRole.class).getProp("status"));

    PropExpression.Num<Long> roleId();

    PropExpression.Str roleCode();

    PropExpression.Str pCode();

    PropExpression.Str roleName();

    PropExpression.Num<Integer> status();
}
