package com.market.system.domain;

import com.market.common.annotation.Excel;
import com.market.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

/**
 * 供应商信息表对象 t_goods_supplier
 *
 * @author jhlz
 * @date 2022-07-06
 */
public class GoodsSupplier extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 供应商社会统一信用码
     */
    @Excel(name = "供应商社会统一信用码")
    private String supplierCode;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称")
    private String supplierName;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String supplierAddress;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String linkMan;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String supplierMobile;

    /**
     * 经营执照（正面）
     */
    @Excel(name = "经营执照", readConverterExp = "正=面")
    private String supplierLicenseFont;

    /**
     * 经营执照（反面）
     */
    @Excel(name = "经营执照", readConverterExp = "反=面")
    private String supplierLicenseBack;

    /**
     * 公司老板
     */
    @Excel(name = "公司老板")
    private String supplierLeader;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String leaderPhone;

    /**
     * 上市日期
     */
    @Excel(name = "上市日期")
    private LocalDate listingDate;

    /**
     * 删除标志（Y代表存在 N代表删除）
     */
    private String delFlag;

    /**
     * 供应/合作状态（0正常 1停用）
     */
    @Excel(name = "供应/合作状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setSupplierMobile(String supplierMobile) {
        this.supplierMobile = supplierMobile;
    }

    public String getSupplierMobile() {
        return supplierMobile;
    }

    public void setSupplierLicenseFont(String supplierLicenseFont) {
        this.supplierLicenseFont = supplierLicenseFont;
    }

    public String getSupplierLicenseFont() {
        return supplierLicenseFont;
    }

    public void setSupplierLicenseBack(String supplierLicenseBack) {
        this.supplierLicenseBack = supplierLicenseBack;
    }

    public String getSupplierLicenseBack() {
        return supplierLicenseBack;
    }

    public void setSupplierLeader(String supplierLeader) {
        this.supplierLeader = supplierLeader;
    }

    public String getSupplierLeader() {
        return supplierLeader;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setListingDate(LocalDate listingDate) {
        this.listingDate = listingDate;
    }

    public LocalDate getListingDate() {
        return listingDate;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("supplierCode", getSupplierCode())
                .append("supplierName", getSupplierName())
                .append("supplierAddress", getSupplierAddress())
                .append("linkMan", getLinkMan())
                .append("supplierMobile", getSupplierMobile())
                .append("supplierLicenseFont", getSupplierLicenseFont())
                .append("supplierLicenseBack", getSupplierLicenseBack())
                .append("supplierLeader", getSupplierLeader())
                .append("leaderPhone", getLeaderPhone())
                .append("listingDate", getListingDate())
                .append("delFlag", getDelFlag())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
