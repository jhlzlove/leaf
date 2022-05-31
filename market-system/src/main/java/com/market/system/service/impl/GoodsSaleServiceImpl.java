package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.system.domain.GoodsSale;
import com.market.system.mapper.GoodsSaleMapper;
import com.market.system.service.IGoodsSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 商品销售Service业务层处理
 *
 * @author jhlz
 * @date 2022-04-13
 */
@Service
public class GoodsSaleServiceImpl implements IGoodsSaleService {
    @Autowired
    private GoodsSaleMapper tGoodsSaleMapper;

    /**
     * 查询商品销售
     *
     * @param id 商品销售主键
     * @return 商品销售
     */
    @Override
    public GoodsSale selectTGoodsSaleById(Long id) {
        return tGoodsSaleMapper.selectTGoodsSaleById(id);
    }

    /**
     * 查询商品销售列表
     *
     * @param goodsSale 商品销售
     * @return 商品销售
     */
    @Override
    public List<GoodsSale> selectTGoodsSaleList(GoodsSale goodsSale) {
        return tGoodsSaleMapper.selectTGoodsSaleList(goodsSale);
    }

    /**
     * 新增商品销售
     *
     * @param goodsSale 商品销售
     * @return 结果
     */
    @Override
    public int insertTGoodsSale(GoodsSale goodsSale) {
        goodsSale.setSaleCode(UUID.randomUUID().toString().replaceAll("-", ""));
        goodsSale.setCreateTime(DateUtils.getNowDate());
        return tGoodsSaleMapper.insertTGoodsSale(goodsSale);
    }

    /**
     * 修改商品销售
     *
     * @param tGoodsSale 商品销售
     * @return 结果
     */
    @Override
    public int updateTGoodsSale(GoodsSale tGoodsSale) {
        tGoodsSale.setUpdateTime(DateUtils.getNowDate());
        return tGoodsSaleMapper.updateTGoodsSale(tGoodsSale);
    }

    /**
     * 批量删除商品销售
     *
     * @param ids 需要删除的商品销售主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsSaleByIds(Long[] ids) {
        return tGoodsSaleMapper.deleteTGoodsSaleByIds(ids);
    }

    /**
     * 删除商品销售信息
     *
     * @param id 商品销售主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsSaleById(Long id) {
        return tGoodsSaleMapper.deleteTGoodsSaleById(id);
    }
}
