package com.market.system.domain;

import com.market.common.annotation.Excel;
import com.market.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工信息对象 t_employee_info
 *
 * @author jhlz
 * @date 2022-04-13
 */
public class EmployeeInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 员工编号
     */
    @Excel(name = "员工编号")
    private String employeeCode;

    /**
     * 员工名称
     */
    @Excel(name = "员工名称")
    private String employeeName;

    /**
     * 员工性别
     */
    @Excel(name = "员工性别")
    private String employeeSex;

    /**
     * 员工部门
     */
    @Excel(name = "员工部门")
    private Long employeeDept;

    /**
     * 住址
     */
    @Excel(name = "住址")
    private String employeeAddress;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String employeePhone;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String employeeCard;

    /**
     * 照片地址
     */
    @Excel(name = "照片地址")
    private String employeePhoto;

    /**
     * 所在省
     */
    @Excel(name = "所在省")
    private String province;

    /**
     * 所在市
     */
    @Excel(name = "所在市")
    private String city;

    /**
     * 乡镇/街道
     */
    @Excel(name = "乡镇/街道")
    private String town;

    /**
     * 删除标志(0:存在;2:删除)
     */
    private String delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeDept(Long employeeDept) {
        this.employeeDept = employeeDept;
    }

    public Long getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeeCard(String employeeCard) {
        this.employeeCard = employeeCard;
    }

    public String getEmployeeCard() {
        return employeeCard;
    }

    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public String getEmployeePhoto() {
        return employeePhoto;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("employeeCode", getEmployeeCode())
                .append("employeeName", getEmployeeName())
                .append("employeeSex", getEmployeeSex())
                .append("employeeDept", getEmployeeDept())
                .append("employeeAddress", getEmployeeAddress())
                .append("employeePhone", getEmployeePhone())
                .append("employeeCard", getEmployeeCard())
                .append("employeePhoto", getEmployeePhoto())
                .append("province", getProvince())
                .append("city", getCity())
                .append("town", getTown())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .toString();
    }
}
