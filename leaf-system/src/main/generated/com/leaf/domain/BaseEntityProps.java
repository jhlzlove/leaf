package com.leaf.domain;

import java.lang.String;
import java.time.LocalDateTime;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
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

    TypedProp.Scalar<BaseEntity, String> CREATE_BY = 
        TypedProp.scalar(ImmutableType.get(BaseEntity.class).getProp("createBy"));

    TypedProp.Scalar<BaseEntity, String> UPDATE_BY = 
        TypedProp.scalar(ImmutableType.get(BaseEntity.class).getProp("updateBy"));

    TypedProp.Scalar<BaseEntity, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(BaseEntity.class).getProp("remark"));

    PropExpression.Cmp<LocalDateTime> createTime();

    PropExpression.Cmp<LocalDateTime> updateTime();

    PropExpression.Str createBy();

    PropExpression.Str updateBy();

    PropExpression.Str remark();
}
