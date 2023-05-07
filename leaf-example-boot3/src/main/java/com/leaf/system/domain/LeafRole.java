package domain;

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
 * 角色表(LeafRole)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Entity(name = "leaf_role")
@DynamicInsert
@DynamicUpdate
public class LeafRole implements Serializable {
    @Serial
    private static final long serialVersionUID = -10322574645123993L;

    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色编码
     */
    private String roleCode;
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


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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
        return "LeafRole{" +
                "roleId=" + roleId + "," +
                "roleName=" + roleName + "," +
                "roleCode=" + roleCode + "," +
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
        LeafRole leafRole = (LeafRole) o;
        return
                Objects.equals(roleId, leafRole.roleId) &&
                        Objects.equals(roleName, leafRole.roleName) &&
                        Objects.equals(roleCode, leafRole.roleCode) &&
                        Objects.equals(status, leafRole.status) &&
                        Objects.equals(delFlag, leafRole.delFlag) &&
                        Objects.equals(createBy, leafRole.createBy) &&
                        Objects.equals(createTime, leafRole.createTime) &&
                        Objects.equals(updateBy, leafRole.updateBy) &&
                        Objects.equals(updateTime, leafRole.updateTime) &&
                        Objects.equals(remark, leafRole.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleCode, status, delFlag, createBy, createTime, updateBy, updateTime, remark);
    }

}

