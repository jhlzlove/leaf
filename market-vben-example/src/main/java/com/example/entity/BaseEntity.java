package com.example.entity;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: jhlz
 * @since: 2022/11/26 15:33:42
 */
public class BaseEntity implements Serializable {

    /**
     * 主键 id
     */
    @Id
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;
}
