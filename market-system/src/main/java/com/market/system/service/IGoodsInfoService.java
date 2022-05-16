package com.market.system.service;

import com.market.system.domain.GoodsInfo;

import java.util.List;

/**
 * 商品信息Service接口
 *
 * @author jhlz
 * @date 2022-04-13
 */
public interface IGoodsInfoService {
    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    public GoodsInfo selectTGoodsInfoById(Long id);

    /**
     * 查询商品信息列表
     *
     * @param tGoodsInfo 商品信息
     * @return 商品信息集合
     */
    public List<GoodsInfo> selectTGoodsInfoList(GoodsInfo tGoodsInfo);

    /**
     * 新增商品信息
     *
     * @param tGoodsInfo 商品信息
     * @return 结果
     */
    public int insertTGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 修改商品信息
     *
     * @param tGoodsInfo 商品信息
     * @return 结果
     */
    public int updateTGoodsInfo(GoodsInfo tGoodsInfo);

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键集合
     * @return 结果
     */
    public int deleteTGoodsInfoByIds(Long[] ids);

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    public int deleteTGoodsInfoById(Long id);
}
