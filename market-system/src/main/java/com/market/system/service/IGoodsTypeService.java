package com.market.system.service;

import com.market.system.domain.GoodsTreeSelect;
import com.market.system.domain.GoodsType;

import java.util.List;

/**
 * 商品类型表Service接口
 *
 * @author jhlz
 * @date 2022-07-08
 */
public interface IGoodsTypeService {
    /**
     * 查询商品类型表
     *
     * @param id 商品类型表主键
     * @return 商品类型表
     */
    public GoodsType selectGoodsTypeById(Long id);

    /**
     * 查询商品类型表列表
     *
     * @param goodsType 商品类型表
     * @return 商品类型表集合
     */
    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType);

    /**
     * 新增商品类型表
     *
     * @param goodsType 商品类型表
     * @return 结果
     */
    public int insertGoodsType(GoodsType goodsType);

    /**
     * 修改商品类型表
     *
     * @param goodsType 商品类型表
     * @return 结果
     */
    public int updateGoodsType(GoodsType goodsType);

    /**
     * 批量删除商品类型表
     *
     * @param ids 需要删除的商品类型表主键集合
     * @return 结果
     */
    public int deleteGoodsTypeByIds(Long[] ids);

    /**
     * 删除商品类型表信息
     *
     * @param id 商品类型表主键
     * @return 结果
     */
    public int deleteGoodsTypeById(Long id);

    /**
     * 构建前端所需要树结构
     *
     * @param goodsTypes 类型列表
     * @return 树结构列表
     */
    List<GoodsType> buildTypeTree(List<GoodsType> goodsTypes);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param goodsTypes 类型列表
     * @return 下拉树结构列表
     */
    List<GoodsTreeSelect> buildTypeTreeSelect(List<GoodsType> goodsTypes);
}
