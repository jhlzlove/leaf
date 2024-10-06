package com.leaf.record;

public record PageRecord(
        /* 第几页 */
        int page,
        /* 每页数量 */
        int size
) {

    public PageRecord() {
        this(1, 10);
    }
}
