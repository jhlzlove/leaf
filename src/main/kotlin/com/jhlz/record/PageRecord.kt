package com.jhlz.record

import jakarta.ws.rs.QueryParam

data class PageRecord( /* 第几页 */
                       @field:QueryParam("page") @param:QueryParam("page") val page: Int,  /* 每页数量 */
                       @field:QueryParam("size") @param:QueryParam("size") val size: Int
)

