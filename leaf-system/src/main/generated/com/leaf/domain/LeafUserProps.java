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

    TypedProp.Reference<LeafUser, LeafUser> CREATE_BY = 
        TypedProp.reference(ImmutableType.get(LeafUser.class).getProp("createBy"));

    TypedProp.Reference<LeafUser, LeafUser> UPDATE_BY = 
        TypedProp.reference(ImmutableType.get(LeafUser.class).getProp("updateBy"));

    TypedProp.Scalar<LeafUser, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("remark"));

    TypedProp.Scalar<LeafUser, String> USERNAME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("username"));

    TypedProp.Scalar<LeafUser, String> PASSWORD = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("password"));

    TypedProp.Scalar<LeafUser, String> NICK_NAME = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("nickName"));

    TypedProp.Scalar<LeafUser, String> AVATAR = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("avatar"));

    TypedProp.Scalar<LeafUser, Integer> STATUS = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("status"));

    TypedProp.Scalar<LeafUser, Integer> DEL_FLAG = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("delFlag"));

    TypedProp.Scalar<LeafUser, String> USER_CODE = 
        TypedProp.scalar(ImmutableType.get(LeafUser.class).getProp("userCode"));

    PropExpression.Num<Long> userId();

    PropExpression.Str username();

    PropExpression.Str password();

    PropExpression.Str nickName();

    PropExpression.Str avatar();

    PropExpression.Num<Integer> status();

    PropExpression.Num<Integer> delFlag();

    PropExpression.Str userCode();
}
