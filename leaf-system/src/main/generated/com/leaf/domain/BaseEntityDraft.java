package com.leaf.domain;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Collections;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.sql.ManyToOne;
import org.jetbrains.annotations.Nullable;

@GeneratedBy(
        type = BaseEntity.class
)
public interface BaseEntityDraft extends BaseEntity, Draft {
    BaseEntityDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    BaseEntityDraft setCreateTime(LocalDateTime createTime);

    @OldChain
    BaseEntityDraft setUpdateTime(LocalDateTime updateTime);

    @Nullable
    LeafUserDraft createBy();

    LeafUserDraft createBy(boolean autoCreate);

    @OldChain
    BaseEntityDraft setCreateBy(LeafUser createBy);

    @Nullable
    Long createById();

    @OldChain
    BaseEntityDraft setCreateById(@Nullable Long createById);

    @OldChain
    BaseEntityDraft applyCreateBy(DraftConsumer<LeafUserDraft> block);

    @OldChain
    BaseEntityDraft applyCreateBy(LeafUser base, DraftConsumer<LeafUserDraft> block);

    @Nullable
    LeafUserDraft updateBy();

    LeafUserDraft updateBy(boolean autoCreate);

    @OldChain
    BaseEntityDraft setUpdateBy(LeafUser updateBy);

    @Nullable
    Long updateById();

    @OldChain
    BaseEntityDraft setUpdateById(@Nullable Long updateById);

    @OldChain
    BaseEntityDraft applyUpdateBy(DraftConsumer<LeafUserDraft> block);

    @OldChain
    BaseEntityDraft applyUpdateBy(LeafUser base, DraftConsumer<LeafUserDraft> block);

    @OldChain
    BaseEntityDraft setRemark(String remark);

    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.109",
                BaseEntity.class,
                Collections.emptyList(),
                null
            )
            .add(-1, "createTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, false)
            .add(-1, "updateTime", ImmutablePropCategory.SCALAR, LocalDateTime.class, false)
            .add(-1, "createBy", ManyToOne.class, LeafUser.class, true)
            .add(-1, "updateBy", ManyToOne.class, LeafUser.class, true)
            .add(-1, "remark", ImmutablePropCategory.SCALAR, String.class, false)
            .build();

        private Producer() {
        }
    }
}
