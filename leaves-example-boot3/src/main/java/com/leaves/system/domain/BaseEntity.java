package com.leaves.system.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 公共属性类
 *
 * @author: jhlz
 * @since: 2022/11/26 15:33:42
 */
@MappedSuperclass
public class BaseEntity {

    /**
     * 主键 id
     * 使用数据库的自增模式 GenerationType.IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * 创建时间
     */
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    protected LocalDateTime updateTime;

    /**
     * 创建人
     */
    @Transient
    protected String createBy;

    /**
     * 更新人
     */
    @Transient
    protected String updateBy;

    /**
     * 备注
     */
    protected String remark;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

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
