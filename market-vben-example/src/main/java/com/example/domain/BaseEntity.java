package com.example.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jhlz
 * @time 2022/8/23 10:41
 * @desc: BaseEntity: 公共属性抽取
 * @MappedSuperclass 注解标识为公共属性类
 */
@Data
@Accessors(chain = true)
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @Column(insertable = false)
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(insertable = false)
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;
}
