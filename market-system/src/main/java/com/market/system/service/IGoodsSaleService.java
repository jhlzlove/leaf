package com.market.system.service;

import com.market.system.domain.GoodsSale;

import java.util.List;

/**
 * 商品销售Service接口
 *
 * @author jhlz
 * @date 2022-04-13
 */
public interface IGoodsSaleService {
    /**
     * 查询商品销售
     *
     * @param id 商品销售主键
     * @return 商品销售
     */
    public GoodsSale selectTGoodsSaleById(Long id);

    /**
     * 查询商品销售列表
     *
     * @param goodsSale 商品销售
     * @return 商品销售集合
     */
    public List<GoodsSale> selectTGoodsSaleList(GoodsSale goodsSale);

    /**
     * 新增商品销售
     *
     * @param tGoodsSale 商品销售
     * @return 结果
     */
    public int insertTGoodsSale(GoodsSale tGoodsSale);

    /**
     * 修改商品销售
     *
     * @param tGoodsSale 商品销售
     * @return 结果
     */
    public int updateTGoodsSale(GoodsSale tGoodsSale);

    /**
     * 批量删除商品销售
     *
     * @param ids 需要删除的商品销售主键集合
     * @return 结果
     */
    public int deleteTGoodsSaleByIds(Long[] ids);

    /**
     * 删除商品销售信息
     *
     * @param id 商品销售主键
     * @return 结果
     */
    public int deleteTGoodsSaleById(Long id);
}
