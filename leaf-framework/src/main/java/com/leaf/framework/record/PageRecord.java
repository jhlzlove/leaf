package com.leaf.framework.record;

import jakarta.ws.rs.QueryParam;

public class PageRecord {

    @QueryParam("page")
    Integer page;
    @QueryParam("size")
    Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


/*     (
         *//* 第几页 *//*
        @QueryParam("page")
        @DefaultValue("0")
        Integer page,
         *//* 每页数量 *//*
        @QueryParam("size")
        @DefaultValue("10")
        Integer size
) */
}
