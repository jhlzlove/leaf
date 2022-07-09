package com.market.system.domain;

import com.market.common.annotation.Excel;
import com.market.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品类型表对象 t_goods_type
 *
 * @author jhlz
 * @date 2022-07-08
 */
public class GoodsType extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String typeName;

    /**
     * 父级分类编号
     */
    @Excel(name = "父级分类编号")
    private String pCode;

    /**
     * 分类编号
     */
    @Excel(name = "分类编号")
    private String typeCode;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpCode() {
        return pCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("typeName", getTypeName())
                .append("pCode", getpCode())
                .append("typeCode", getTypeCode())
                .toString();
    }
}
