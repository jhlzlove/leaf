package com.leaf.system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * 字典表(LeafDict)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Entity(name = "leaf_dict")
@DynamicInsert
@DynamicUpdate
public class LeafDict implements Serializable {
    @Serial
    private static final long serialVersionUID = 131002912756133624L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dictId;
    /**
     * 字典键
     */
    private String dictKey;
    /**
     * 字典值
     */
    private String dictValue;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 状态：1正常，0禁用
     */
    private Integer status;
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


    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "LeafDict{" +
                "dictId=" + dictId + "," +
                "dictKey=" + dictKey + "," +
                "dictValue=" + dictValue + "," +
                "dictType=" + dictType + "," +
                "status=" + status + "," +
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
        LeafDict leafDict = (LeafDict) o;
        return
                Objects.equals(dictId, leafDict.dictId) &&
                        Objects.equals(dictKey, leafDict.dictKey) &&
                        Objects.equals(dictValue, leafDict.dictValue) &&
                        Objects.equals(dictType, leafDict.dictType) &&
                        Objects.equals(status, leafDict.status) &&
                        Objects.equals(createBy, leafDict.createBy) &&
                        Objects.equals(createTime, leafDict.createTime) &&
                        Objects.equals(updateBy, leafDict.updateBy) &&
                        Objects.equals(updateTime, leafDict.updateTime) &&
                        Objects.equals(remark, leafDict.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictId, dictKey, dictValue, dictType, status, createBy, createTime, updateBy, updateTime, remark);
    }

}

