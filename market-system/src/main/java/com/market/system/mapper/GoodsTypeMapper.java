package com.market.system.mapper;

import java.util.List;
import com.market.system.domain.GoodsType;

/**
 * 商品类型表Mapper接口
 * 
 * @author jhlz
 * @date 2022-07-08
 */
public interface GoodsTypeMapper 
{
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
     * 删除商品类型表
     * 
     * @param id 商品类型表主键
     * @return 结果
     */
    public int deleteGoodsTypeById(Long id);

    /**
     * 批量删除商品类型表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsTypeByIds(Long[] ids);
}
