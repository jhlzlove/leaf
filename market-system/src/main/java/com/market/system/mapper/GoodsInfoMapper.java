package com.market.system.mapper;

import java.util.List;
import com.market.system.domain.GoodsInfo;

/**
 * 商品信息Mapper接口
 * 
 * @author jhlz
 * @date 2022-07-08
 */
public interface GoodsInfoMapper 
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
     * 删除商品信息
     * 
     * @param id 商品信息主键
     * @return 结果
     */
    public int deleteGoodsInfoById(Long id);

    /**
     * 批量删除商品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsInfoByIds(Long[] ids);
}
