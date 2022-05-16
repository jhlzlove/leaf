package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.system.domain.GoodsSupplier;
import com.market.system.mapper.GoodsSupplierMapper;
import com.market.system.service.IGoodsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供货商信息Service业务层处理
 * 
 * @author jhlz
 * @date 2022-04-13
 */
@Service
public class GoodsSupplierServiceImpl implements IGoodsSupplierService
{
    @Autowired
    private GoodsSupplierMapper tGoodsSupplierMapper;

    /**
     * 查询供货商信息
     * 
     * @param id 供货商信息主键
     * @return 供货商信息
     */
    @Override
    public GoodsSupplier selectTGoodsSupplierById(Long id)
    {
        return tGoodsSupplierMapper.selectTGoodsSupplierById(id);
    }

    /**
     * 查询供货商信息列表
     * 
     * @param tGoodsSupplier 供货商信息
     * @return 供货商信息
     */
    @Override
    public List<GoodsSupplier> selectTGoodsSupplierList(GoodsSupplier tGoodsSupplier)
    {
        return tGoodsSupplierMapper.selectTGoodsSupplierList(tGoodsSupplier);
    }

    /**
     * 新增供货商信息
     * 
     * @param tGoodsSupplier 供货商信息
     * @return 结果
     */
    @Override
    public int insertTGoodsSupplier(GoodsSupplier tGoodsSupplier)
    {
        tGoodsSupplier.setCreateTime(DateUtils.getNowDate());
        return tGoodsSupplierMapper.insertTGoodsSupplier(tGoodsSupplier);
    }

    /**
     * 修改供货商信息
     * 
     * @param tGoodsSupplier 供货商信息
     * @return 结果
     */
    @Override
    public int updateTGoodsSupplier(GoodsSupplier tGoodsSupplier)
    {
        tGoodsSupplier.setUpdateTime(DateUtils.getNowDate());
        return tGoodsSupplierMapper.updateTGoodsSupplier(tGoodsSupplier);
    }

    /**
     * 批量删除供货商信息
     * 
     * @param ids 需要删除的供货商信息主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsSupplierByIds(Long[] ids)
    {
        return tGoodsSupplierMapper.deleteTGoodsSupplierByIds(ids);
    }

    /**
     * 删除供货商信息信息
     * 
     * @param id 供货商信息主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsSupplierById(Long id)
    {
        return tGoodsSupplierMapper.deleteTGoodsSupplierById(id);
    }
}
