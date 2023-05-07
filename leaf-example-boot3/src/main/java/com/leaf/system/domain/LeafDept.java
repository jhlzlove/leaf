package com.leaf.system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.io.Serial;
import java.io.Serializable;


/**
 * 部门表(LeafDept)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:02
 */
@Entity(name = "leaf_dept")
@DynamicInsert
@DynamicUpdate
public class LeafDept implements Serializable {
    @Serial
    private static final long serialVersionUID = -99755446519962889L;

    private Long deptId;
    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 父级部门id
     */
    private Long parentId;
    /**
     * 部门负责人id
     */
    private Long leaderId;
    /**
     * 部门描述
     */
    private String description;
    /**
     * 状态：1正常，0禁用
     */
    private Integer status;
    /**
     * 是否删除：true(b'1')已删除，false(b'0')正常
     */
    private Boolean delFlag;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    private String remark;


    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LeafDept{" +
                "deptId=" + deptId + "," +
                "deptCode=" + deptCode + "," +
                "deptName=" + deptName + "," +
                "parentId=" + parentId + "," +
                "leaderId=" + leaderId + "," +
                "description=" + description + "," +
                "status=" + status + "," +
                "delFlag=" + delFlag + "," +
                "createBy=" + createBy + "," +
                "createTime=" + createTime + "," +
                "updateBy=" + updateBy + "," +
                "updateTime=" + updateTime + "," +
                "remark=" + remark +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafDept leafDept = (LeafDept) o;
        return
                Objects.equals(deptId, leafDept.deptId) &&
                        Objects.equals(deptCode, leafDept.deptCode) &&
                        Objects.equals(deptName, leafDept.deptName) &&
                        Objects.equals(parentId, leafDept.parentId) &&
                        Objects.equals(leaderId, leafDept.leaderId) &&
                        Objects.equals(description, leafDept.description) &&
                        Objects.equals(status, leafDept.status) &&
                        Objects.equals(delFlag, leafDept.delFlag) &&
                        Objects.equals(createBy, leafDept.createBy) &&
                        Objects.equals(createTime, leafDept.createTime) &&
                        Objects.equals(updateBy, leafDept.updateBy) &&
                        Objects.equals(updateTime, leafDept.updateTime) &&
                        Objects.equals(remark, leafDept.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptCode, deptName, parentId, leaderId, description, status, delFlag, createBy, createTime, updateBy, updateTime, remark);
    }

}

