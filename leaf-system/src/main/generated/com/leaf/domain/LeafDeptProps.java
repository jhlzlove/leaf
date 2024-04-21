package com.leaf.domain;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = LeafDept.class
)
@PropsFor(LeafDept.class)
public interface LeafDeptProps extends BaseEntityProps {
    TypedProp.Scalar<LeafDept, Long> DEPT_ID = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("deptId"));

    TypedProp.Scalar<LeafDept, LocalDateTime> CREATE_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("createTime"));

    TypedProp.Scalar<LeafDept, LocalDateTime> UPDATE_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("updateTime"));

    TypedProp.Scalar<LeafDept, String> CREATE_BY = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("createBy"));

    TypedProp.Scalar<LeafDept, String> UPDATE_BY = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("updateBy"));

    TypedProp.Scalar<LeafDept, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("remark"));

    TypedProp.Scalar<LeafDept, String> DEPT_NAME = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("deptName"));

    TypedProp.Scalar<LeafDept, Long> PARENT_ID = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("parentId"));

    TypedProp.Scalar<LeafDept, String> DEPT_CODE = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("deptCode"));

    TypedProp.Scalar<LeafDept, Long> LEADER_ID = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("leaderId"));

    TypedProp.Scalar<LeafDept, String> DESCRIPTION = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("description"));

    TypedProp.Scalar<LeafDept, Integer> STATUS = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("status"));

    TypedProp.Scalar<LeafDept, Integer> SORTABLE = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("sortable"));

    TypedProp.Scalar<LeafDept, Long> ROLE_ID = 
        TypedProp.scalar(ImmutableType.get(LeafDept.class).getProp("roleId"));

    TypedProp.ReferenceList<LeafDept, LeafUser> USER_LIST = 
        TypedProp.referenceList(ImmutableType.get(LeafDept.class).getProp("userList"));

    PropExpression.Num<Long> deptId();

    PropExpression.Str deptName();

    PropExpression.Num<Long> parentId();

    PropExpression.Str deptCode();

    PropExpression.Num<Long> leaderId();

    PropExpression.Str description();

    PropExpression.Num<Integer> status();

    PropExpression.Num<Integer> sortable();

    PropExpression.Num<Long> roleId();

    Predicate userList(Function<LeafUserTableEx, Predicate> block);
}
