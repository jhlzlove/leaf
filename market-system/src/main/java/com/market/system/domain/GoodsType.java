package com.market.system.domain;

/**
 * 商品类型表
 */
public class GoodsType {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 父级类型编号
     */
    private String pCode;

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
                ", pCode='" + pCode + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
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
