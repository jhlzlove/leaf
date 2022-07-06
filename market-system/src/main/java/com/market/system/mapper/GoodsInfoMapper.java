package com.market.system.mapper;

import com.market.system.domain.GoodsInfo;
import com.market.system.domain.GoodsType;

import java.util.List;

/**
 * 商品信息Mapper接口
 *
 * @author jhlz
 * @date 2022-07-06
 */
public interface GoodsInfoMapper {
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

    /**
     * 批量删除商品类型表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsTypeByTypeCodes(Long[] ids);

    /**
     * 批量新增商品类型表
     *
     * @param goodsTypeList 商品类型表列表
     * @return 结果
     */
    public int batchGoodsType(List<GoodsType> goodsTypeList);


    /**
     * 通过商品信息主键删除商品类型表信息
     *
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteGoodsTypeByTypeCode(Long id);
}
