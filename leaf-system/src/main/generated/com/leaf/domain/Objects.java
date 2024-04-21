package com.leaf.domain;

import org.babyfish.jimmer.DraftConsumer;

public interface Objects {
    static LeafDept createLeafDept(DraftConsumer<LeafDeptDraft> block) {
        return LeafDeptDraft.$.produce(block);
    }

    static LeafDept createLeafDept(LeafDept base, DraftConsumer<LeafDeptDraft> block) {
        return LeafDeptDraft.$.produce(base, block);
    }

    static LeafRole createLeafRole(DraftConsumer<LeafRoleDraft> block) {
        return LeafRoleDraft.$.produce(block);
    }

    static LeafRole createLeafRole(LeafRole base, DraftConsumer<LeafRoleDraft> block) {
        return LeafRoleDraft.$.produce(base, block);
    }

    static LeafUser createLeafUser(DraftConsumer<LeafUserDraft> block) {
        return LeafUserDraft.$.produce(block);
    }

    static LeafUser createLeafUser(LeafUser base, DraftConsumer<LeafUserDraft> block) {
        return LeafUserDraft.$.produce(base, block);
    }

    static LeafUserDetail createLeafUserDetail(DraftConsumer<LeafUserDetailDraft> block) {
        return LeafUserDetailDraft.$.produce(block);
    }

    static LeafUserDetail createLeafUserDetail(LeafUserDetail base,
            DraftConsumer<LeafUserDetailDraft> block) {
        return LeafUserDetailDraft.$.produce(base, block);
    }
}
