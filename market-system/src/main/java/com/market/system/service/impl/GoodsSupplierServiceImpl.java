package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.system.domain.GoodsSupplier;
import com.market.system.mapper.GoodsSupplierMapper;
import com.market.system.service.IGoodsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商信息表Service业务层处理
 *
 * @author jhlz
 * @date 2022-07-06
 */
@Service
public class GoodsSupplierServiceImpl implements IGoodsSupplierService {
    @Autowired
    private GoodsSupplierMapper goodsSupplierMapper;

    /**
     * 查询供应商信息表
     *
     * @param id 供应商信息表主键
     * @return 供应商信息表
     */
    @Override
    public GoodsSupplier selectGoodsSupplierById(Long id) {
        return goodsSupplierMapper.selectGoodsSupplierById(id);
    }

    /**
     * 查询供应商信息表列表
     *
     * @param goodsSupplier 供应商信息表
     * @return 供应商信息表
     */
    @Override
    public List<GoodsSupplier> selectGoodsSupplierList(GoodsSupplier goodsSupplier) {
        return goodsSupplierMapper.selectGoodsSupplierList(goodsSupplier);
    }

    /**
     * 新增供应商信息表
     *
     * @param goodsSupplier 供应商信息表
     * @return 结果
     */
    @Override
    public int insertGoodsSupplier(GoodsSupplier goodsSupplier) {
        goodsSupplier.setCreateTime(DateUtils.getNowDate());
        return goodsSupplierMapper.insertGoodsSupplier(goodsSupplier);
    }

    /**
     * 修改供应商信息表
     *
     * @param goodsSupplier 供应商信息表
     * @return 结果
     */
    @Override
    public int updateGoodsSupplier(GoodsSupplier goodsSupplier) {
        goodsSupplier.setUpdateTime(DateUtils.getNowDate());
        return goodsSupplierMapper.updateGoodsSupplier(goodsSupplier);
    }

    /**
     * 批量删除供应商信息表
     *
     * @param ids 需要删除的供应商信息表主键
     * @return 结果
     */
    @Override
    public int deleteGoodsSupplierByIds(Long[] ids) {
        return goodsSupplierMapper.deleteGoodsSupplierByIds(ids);
    }

    /**
     * 删除供应商信息表信息
     *
     * @param id 供应商信息表主键
     * @return 结果
     */
    @Override
    public int deleteGoodsSupplierById(Long id) {
        return goodsSupplierMapper.deleteGoodsSupplierById(id);
    }
}
