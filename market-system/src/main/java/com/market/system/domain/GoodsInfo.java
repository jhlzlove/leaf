package com.market.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.market.common.annotation.Excel;
import com.market.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品信息对象 t_goods_info
 *
 * @author jhlz
 * @date 2022-07-06
 */
public class GoodsInfo extends BaseEntity {
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
     * 商品类型
     */
    @Excel(name = "商品类型")
    private String goodsType;

    /**
     * 商品供货商编码
     */
    @Excel(name = "商品供货商编码")
    private String goodsSupplier;

    /**
     * 商品数量
     */
    @Excel(name = "商品数量")
    private Long goodsNumber;

    /**
     * 商品定价
     */
    @Excel(name = "商品定价")
    private BigDecimal goodsPrice;

    /**
     * 折扣
     */
    @Excel(name = "折扣")
    private String goodsDiscount;

    /**
     * 优惠价格
     */
    @Excel(name = "优惠价格")
    private BigDecimal goodsPreferential;

    /**
     * 生产日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufacturingDate;

    /**
     * 保质期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保质期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saveDate;

    /**
     * 计量方式
     */
    @Excel(name = "计量方式")
    private String meteringWay;

    /**
     * 供应状态（0正常 1下架）
     * 供应状态（0正常 1下架）
     * 供应状态（0正常 1下架）
     */
    @Excel(name = "供应状态", readConverterExp = "0=正常,1=下架")
    private String status;

    /**
     * 删除标志（Y代表存在 N代表删除）
     */
    private String delFlag;

    /**
     * 商品类型表信息
     */
    private List<GoodsType> goodsTypeList;

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

    public void setGoodsSupplier(String goodsSupplier) {
        this.goodsSupplier = goodsSupplier;
    }

    public String getGoodsSupplier() {
        return goodsSupplier;
    }

    public void setGoodsNumber(Long goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Long getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsDiscount(String goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }

    public String getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsPreferential(BigDecimal goodsPreferential) {
        this.goodsPreferential = goodsPreferential;
    }

    public BigDecimal getGoodsPreferential() {
        return goodsPreferential;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setMeteringWay(String meteringWay) {
        this.meteringWay = meteringWay;
    }

    public String getMeteringWay() {
        return meteringWay;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public List<GoodsType> getGoodsTypeList() {
        return goodsTypeList;
    }

    public void setGoodsTypeList(List<GoodsType> goodsTypeList) {
        this.goodsTypeList = goodsTypeList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("goodsCode", getGoodsCode())
                .append("goodsName", getGoodsName())
                .append("goodsType", getGoodsType())
                .append("goodsSupplier", getGoodsSupplier())
                .append("goodsNumber", getGoodsNumber())
                .append("goodsPrice", getGoodsPrice())
                .append("goodsDiscount", getGoodsDiscount())
                .append("goodsPreferential", getGoodsPreferential())
                .append("manufacturingDate", getManufacturingDate())
                .append("saveDate", getSaveDate())
                .append("meteringWay", getMeteringWay())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("goodsTypeList", getGoodsTypeList())
                .toString();
    }
}
