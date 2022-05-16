package com.market.system.mapper;

import com.market.system.domain.GoodsSupplier;

import java.util.List;

/**
 * 供货商信息Mapper接口
 *
 * @author jhlz
 * @date 2022-04-13
 */
public interface GoodsSupplierMapper {
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
     * 删除供货商信息
     *
     * @param id 供货商信息主键
     * @return 结果
     */
    public int deleteTGoodsSupplierById(Long id);

    /**
     * 批量删除供货商信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTGoodsSupplierByIds(Long[] ids);
}
