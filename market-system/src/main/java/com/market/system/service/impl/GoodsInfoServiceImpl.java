package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.system.domain.GoodsInfo;
import com.market.system.mapper.GoodsInfoMapper;
import com.market.system.service.IGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品信息Service业务层处理
 *
 * @author jhlz
 * @date 2022-04-13
 */
@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
    @Autowired
    private GoodsInfoMapper tGoodsInfoMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    @Override
    public GoodsInfo selectTGoodsInfoById(Long id) {
        return tGoodsInfoMapper.selectTGoodsInfoById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param tGoodsInfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<GoodsInfo> selectTGoodsInfoList(GoodsInfo tGoodsInfo) {
        return tGoodsInfoMapper.selectTGoodsInfoList(tGoodsInfo);
    }

    /**
     * 新增商品信息
     *
     * @param goodsInfo 商品信息
     * @return 结果
     */
    @Override
    public int insertTGoodsInfo(GoodsInfo goodsInfo) {
        goodsInfo.setGoodsCode(System.currentTimeMillis() + "");
        goodsInfo.setCreateTime(DateUtils.getNowDate());
        return tGoodsInfoMapper.insertTGoodsInfo(goodsInfo);
    }

    /**
     * 修改商品信息
     *
     * @param tGoodsInfo 商品信息
     * @return 结果
     */
    @Override
    public int updateTGoodsInfo(GoodsInfo tGoodsInfo) {
        tGoodsInfo.setUpdateTime(DateUtils.getNowDate());
        return tGoodsInfoMapper.updateTGoodsInfo(tGoodsInfo);
    }

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsInfoByIds(Long[] ids) {
        return tGoodsInfoMapper.deleteTGoodsInfoByIds(ids);
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsInfoById(Long id) {
        return tGoodsInfoMapper.deleteTGoodsInfoById(id);
    }
}
