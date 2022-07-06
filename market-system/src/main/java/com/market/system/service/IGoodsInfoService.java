package com.market.system.service;

import java.util.List;
import com.market.system.domain.GoodsInfo;

/**
 * 商品信息Service接口
 * 
 * @author jhlz
 * @date 2022-07-06
 */
public interface IGoodsInfoService 
{
    /**
     * 查询商品信息
     * 
     * @param id 商品信息主键
     * @return 商品信息
     */
    public GoodsInfo selectGoodsInfoById(Long id);

    /**
     * 查询商品信息列表
     * 
     * @param goodsInfo 商品信息
     * @return 商品信息集合
     */
    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo);

    /**
     * 新增商品信息
     * 
     * @param goodsInfo 商品信息
     * @return 结果
     */
    public int insertGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 修改商品信息
     * 
     * @param goodsInfo 商品信息
     * @return 结果
     */
    public int updateGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 批量删除商品信息
     * 
     * @param ids 需要删除的商品信息主键集合
     * @return 结果
     */
    public int deleteGoodsInfoByIds(Long[] ids);

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息主键
     * @return 结果
     */
    public int deleteGoodsInfoById(Long id);
}
