package com.market.system.domain;

/**
 * 商品类型表
 */
public class GoodsType {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 类型编号
     */
    private String typeCode;

    /**
     * 类型名称
     */
    private String typeName;

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typeCode='" + typeCode + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
