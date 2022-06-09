package com.market.system.domain;

import com.market.common.annotation.Excel;
import com.market.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 商品销售对象 t_goods_sale
 *
 * @author jhlz
 * @date 2022-04-13
 */
public class GoodsSale extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 商品售出单号
     */
    @Excel(name = "售出编码")
    private String saleCode;
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
     * 商品类型
     */
    @Excel(name = "商品类型")
    private String goodsType;

    /**
     * 售出数量
     */
    @Excel(name = "售出数量")
    private Long goodsSaleNum;

    /**
     * 计量方式
     */
    @Excel(name = "计量方式")
    private String meteringWay;

    /**
     * 应付金额
     */
    @Excel(name = "应付金额")
    private BigDecimal amountPayable;

    /**
     * 实付金额
     */
    @Excel(name = "实付金额")
    private BigDecimal amountActual;

    /**
     * 找零
     */
    @Excel(name = "找零")
    private BigDecimal amountChange;

    /**
     * 顶部信息
     */
    @Excel(name = "顶部信息")
    private String topDesc;

    /**
     * 底部信息
     */
    @Excel(name = "底部信息")
    private String bottomDesc;

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

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

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsSaleNum(Long goodsSaleNum) {
        this.goodsSaleNum = goodsSaleNum;
    }

    public Long getGoodsSaleNum() {
        return goodsSaleNum;
    }

    public void setMeteringWay(String meteringWay) {
        this.meteringWay = meteringWay;
    }

    public String getMeteringWay() {
        return meteringWay;
    }

    public void setAmountPayable(BigDecimal amountPayable) {
        this.amountPayable = amountPayable;
    }

    public BigDecimal getAmountPayable() {
        return amountPayable;
    }

    public void setAmountActual(BigDecimal amountActual) {
        this.amountActual = amountActual;
    }

    public BigDecimal getAmountActual() {
        return amountActual;
    }

    public void setAmountChange(BigDecimal amountChange) {
        this.amountChange = amountChange;
    }

    public BigDecimal getAmountChange() {
        return amountChange;
    }

    public void setTopDesc(String topDesc) {
        this.topDesc = topDesc;
    }

    public String getTopDesc() {
        return topDesc;
    }

    public void setBottomDesc(String bottomDesc) {
        this.bottomDesc = bottomDesc;
    }

    public String getBottomDesc() {
        return bottomDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("saleCode", getSaleCode())
                .append("goodsCode", getGoodsCode())
                .append("goodsName", getGoodsName())
                .append("goodsType", getGoodsType())
                .append("goodsSaleNum", getGoodsSaleNum())
                .append("meteringWay", getMeteringWay())
                .append("amountPayable", getAmountPayable())
                .append("amountActual", getAmountActual())
                .append("change", getAmountChange())
                .append("topDesc", getTopDesc())
                .append("bottomDesc", getBottomDesc())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .toString();
    }
}
