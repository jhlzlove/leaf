package com.example.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class SysDept extends BaseEntity {

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 状态（0启用 1禁用）
     */
    @Column(insertable = false)
    private Boolean status;

    @OneToMany
    @Transient
    private List<SysDept> children;

}

