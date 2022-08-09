package com.market.system.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.market.common.core.domain.TreeSelect;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GoodsTreeselect树结构实体类
 *
 * @author jhlz
 */
public class GoodsTreeSelect implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    private Long id;

    /**
     * 节点名称
     */
    private String label;

    /**
     * 子节点
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GoodsTreeSelect> children;

    public GoodsTreeSelect() {

    }

    public GoodsTreeSelect(GoodsType goodsType) {
        this.id = goodsType.getTypeCode();
        this.label = goodsType.getTypeName();
        this.children = goodsType.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<GoodsTreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsTreeSelect> children) {
        this.children = children;
    }

}
