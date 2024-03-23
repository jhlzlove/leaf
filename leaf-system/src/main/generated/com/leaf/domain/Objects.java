package com.leaf.domain;

import org.babyfish.jimmer.DraftConsumer;

public interface Objects {
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
}
