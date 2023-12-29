package com.leaf.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 公共属性类
 *
 * @author jhlz
 * @since 2022/11/26 15:33:42
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "create_time")
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "update_time")
    protected LocalDateTime updateTime;

    /**
     * 创建人
     */
    @CreatedBy
    @Column(name = "create_by")
    protected String createBy;

    /**
     * 更新人
     */
    @LastModifiedBy
    @Column(name = "update_by")
    protected String updateBy;

    /**
     * 备注
     */
    @Column(name = "remark")
    protected String remark;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BaseEntity setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public BaseEntity setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public BaseEntity setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public BaseEntity setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public BaseEntity setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }
}
