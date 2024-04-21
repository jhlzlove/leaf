package com.leaf.domain;

import java.lang.String;
import java.time.LocalDateTime;
import java.util.Collections;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;

@GeneratedBy(
        type = BaseEntity.class
)
public interface BaseEntityDraft extends BaseEntity, Draft {
    BaseEntityDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    BaseEntityDraft setCreateTime(LocalDateTime createTime);

    @OldChain
    BaseEntityDraft setUpdateTime(LocalDateTime updateTime);

    @OldChain
    BaseEntityDraft setCreateBy(String createBy);

    @OldChain
    BaseEntityDraft setUpdateBy(String updateBy);

    @OldChain
    BaseEntityDraft setRemark(String remark);

    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.125",
                BaseEntity.class,
                Collections.emptyList(),
                null
            )
            .add(-1, "createTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, true)
            .add(-1, "updateTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, true)
            .add(-1, "createBy", ImmutablePropCategory.SCALAR, String.class, true)
            .add(-1, "updateBy", ImmutablePropCategory.SCALAR, String.class, true)
            .add(-1, "remark", ImmutablePropCategory.SCALAR, String.class, true)
            .build();

        private Producer() {
        }
    }
}
