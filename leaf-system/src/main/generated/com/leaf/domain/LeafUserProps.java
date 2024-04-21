package com.leaf.domain;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = LeafUser.class
)
@PropsFor(LeafUser.class)
public interface LeafUserProps extends BaseEntityProps {
    TypedProp.Scalar<LeafUser, Long> USER_ID = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("userId"));

    TypedProp.Scalar<LeafUser, LocalDateTime> CREATE_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("createTime"));

    TypedProp.Scalar<LeafUser, LocalDateTime> UPDATE_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("updateTime"));

    TypedProp.Scalar<LeafUser, String> CREATE_BY = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("createBy"));

    TypedProp.Scalar<LeafUser, String> UPDATE_BY = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("updateBy"));

    TypedProp.Scalar<LeafUser, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("remark"));

    TypedProp.Scalar<LeafUser, String> USERNAME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("username"));

    TypedProp.Scalar<LeafUser, String> PASSWORD = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("password"));

    TypedProp.Scalar<LeafUser, String> NICK_NAME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("nickName"));

    TypedProp.Scalar<LeafUser, String> PHONE = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("phone"));

    TypedProp.Scalar<LeafUser, String> EMAIL = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("email"));

    TypedProp.Scalar<LeafUser, String> AVATAR = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("avatar"));

    TypedProp.Scalar<LeafUser, LocalDate> LAST_LOGIN_TIME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("lastLoginTime"));

    TypedProp.Scalar<LeafUser, Integer> STATUS = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("status"));

    TypedProp.Scalar<LeafUser, Long> USER_DETAIL_ID = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("userDetailId"));

    TypedProp.Reference<LeafUser, LeafUserDetail> USER_DETAIL = 
        TypedProp.reference(ImmutableType.get(LeafUser.class).getProp("userDetail"));

    TypedProp.ReferenceList<LeafUser, LeafDept> DEPT_LIST = 
        TypedProp.referenceList(ImmutableType.get(LeafUser.class).getProp("deptList"));

    PropExpression.Num<Long> userId();

    PropExpression.Str username();

    PropExpression.Str password();

    PropExpression.Str nickName();

    PropExpression.Str phone();

    PropExpression.Str email();

    PropExpression.Str avatar();

    PropExpression.Cmp<LocalDate> lastLoginTime();

    PropExpression.Num<Integer> status();

    LeafUserDetailTable userDetail();

    LeafUserDetailTable userDetail(JoinType joinType);

    PropExpression.Num<Long> userDetailId();

    Predicate deptList(Function<LeafDeptTableEx, Predicate> block);
}
