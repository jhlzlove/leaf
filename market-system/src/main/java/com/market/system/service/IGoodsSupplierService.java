package com.market.system.service;

import java.util.List;

import com.market.system.domain.GoodsSupplier;

/**
 * 供货商信息Service接口
 *
 * @author jhlz
 * @date 2022-04-13
 */
public interface IGoodsSupplierService {
    /**
     * 查询供货商信息
     *
     * @param id 供货商信息主键
     * @return 供货商信息
     */
    public GoodsSupplier selectTGoodsSupplierById(Long id);

    /**
     * 查询供货商信息列表
     *
     * @param tGoodsSupplier 供货商信息
     * @return 供货商信息集合
     */
    public List<GoodsSupplier> selectTGoodsSupplierList(GoodsSupplier tGoodsSupplier);

    /**
     * 新增供货商信息
     *
     * @param tGoodsSupplier 供货商信息
     * @return 结果
     */
    public int insertTGoodsSupplier(GoodsSupplier tGoodsSupplier);

    /**
     * 修改供货商信息
     *
     * @param tGoodsSupplier 供货商信息
     * @return 结果
     */
    public int updateTGoodsSupplier(GoodsSupplier tGoodsSupplier);

    /**
     * 批量删除供货商信息
     *
     * @param ids 需要删除的供货商信息主键集合
     * @return 结果
     */
    public int deleteTGoodsSupplierByIds(Long[] ids);

    /**
     * 删除供货商信息信息
     *
     * @param id 供货商信息主键
     * @return 结果
     */
    public int deleteTGoodsSupplierById(Long id);
}
