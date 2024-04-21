package com.leaf.domain;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = LeafUserDetail.class
)
@PropsFor(LeafUserDetail.class)
public interface LeafUserDetailProps extends Props {
    TypedProp.Scalar<LeafUserDetail, Long> USER_DETAIL_ID = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("userDetailId"));

    TypedProp.Scalar<LeafUserDetail, String> FIRST_NAME = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("firstName"));

    TypedProp.Scalar<LeafUserDetail, String> LAST_NAME = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("lastName"));

    TypedProp.Scalar<LeafUserDetail, String> ETHNIC = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("ethnic"));

    TypedProp.Scalar<LeafUserDetail, String> GENDER = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("gender"));

    TypedProp.Scalar<LeafUserDetail, Integer> AGE = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("age"));

    TypedProp.Scalar<LeafUserDetail, String> ADDRESS = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("address"));

    TypedProp.Scalar<LeafUserDetail, String> HOMETOWN = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("hometown"));

    TypedProp.Scalar<LeafUserDetail, String> ID_CARD = 
        TypedProp.scalar(ImmutableType.get(LeafUserDetail.class).getProp("idCard"));

    TypedProp.ReferenceList<LeafUserDetail, LeafUser> USERS = 
        TypedProp.referenceList(ImmutableType.get(LeafUserDetail.class).getProp("users"));

    PropExpression.Num<Long> userDetailId();

    PropExpression.Str firstName();

    PropExpression.Str lastName();

    PropExpression.Str ethnic();

    PropExpression.Str gender();

    PropExpression.Num<Integer> age();

    PropExpression.Str address();

    PropExpression.Str hometown();

    PropExpression.Str idCard();

    Predicate users(Function<LeafUserTableEx, Predicate> block);
}
