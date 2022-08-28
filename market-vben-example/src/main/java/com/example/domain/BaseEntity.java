package com.example.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jhlz
 * @time 2022/8/23 10:41
 * @desc: BaseEntity
 */
public class BaseEntity implements Serializable {
    /**
     * 创建者
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
}