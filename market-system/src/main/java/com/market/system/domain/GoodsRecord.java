package com.market.system.domain;

import com.market.common.annotation.Excel;
import com.market.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 记录对象 t_goods_record
 *
 * @author jhlz
 * @date 2022-04-13
 */
public class GoodsRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 商品编码
     */
    @Excel(name = "商品编码")
    private String goodsCode;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String goodsName;

    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private String recordCode;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getRecordCode() {
        return recordCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("goodsCode", getGoodsCode())
                .append("goodsName", getGoodsName())
                .append("recordCode", getRecordCode())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .toString();
    }
}
