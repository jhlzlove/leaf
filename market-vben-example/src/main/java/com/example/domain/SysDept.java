package com.example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
@Data
@Entity
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
    private Boolean status;

    @OneToMany
    private List<SysDept> children;

}

