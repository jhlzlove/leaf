package com.leaf.domain;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = BaseEntity.class
)
@PropsFor(BaseEntity.class)
public interface BaseEntityProps extends Props {
    TypedProp.Scalar<BaseEntity, LocalDateTime> CREATE_TIME = 
        TypedProp.scalar(ImmutableType.get(BaseEntity.class).getProp("createTime"));

    TypedProp.Scalar<BaseEntity, LocalDateTime> UPDATE_TIME = 
        TypedProp.scalar(ImmutableType.get(BaseEntity.class).getProp("updateTime"));

    TypedProp.Reference<BaseEntity, LeafUser> CREATE_BY = 
        TypedProp.reference(ImmutableType.get(BaseEntity.class).getProp("createBy"));

    TypedProp.Reference<BaseEntity, LeafUser> UPDATE_BY = 
        TypedProp.reference(ImmutableType.get(BaseEntity.class).getProp("updateBy"));

    TypedProp.Scalar<BaseEntity, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(BaseEntity.class).getProp("remark"));

    PropExpression.Cmp<LocalDateTime> createTime();

    PropExpression.Cmp<LocalDateTime> updateTime();

    LeafUserTable createBy();

    LeafUserTable createBy(JoinType joinType);

    PropExpression.Num<Long> createById();

    LeafUserTable updateBy();

    LeafUserTable updateBy(JoinType joinType);

    PropExpression.Num<Long> updateById();

    PropExpression.Str remark();
}
