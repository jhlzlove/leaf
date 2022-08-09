package com.market.system.mapper;

import com.market.system.domain.GoodsSupplier;

import java.util.List;

/**
 * 供应商信息表Mapper接口
 *
 * @author jhlz
 * @date 2022-07-06
 */
public interface GoodsSupplierMapper {
    /**
     * 查询供应商信息表
     *
     * @param id 供应商信息表主键
     * @return 供应商信息表
     */
    public GoodsSupplier selectGoodsSupplierById(Long id);

    /**
     * 查询供应商信息表列表
     *
     * @param goodsSupplier 供应商信息表
     * @return 供应商信息表集合
     */
    public List<GoodsSupplier> selectGoodsSupplierList(GoodsSupplier goodsSupplier);

    /**
     * 新增供应商信息表
     *
     * @param goodsSupplier 供应商信息表
     * @return 结果
     */
    public int insertGoodsSupplier(GoodsSupplier goodsSupplier);

    /**
     * 修改供应商信息表
     *
     * @param goodsSupplier 供应商信息表
     * @return 结果
     */
    public int updateGoodsSupplier(GoodsSupplier goodsSupplier);

    /**
     * 删除供应商信息表
     *
     * @param id 供应商信息表主键
     * @return 结果
     */
    public int deleteGoodsSupplierById(Long id);

    /**
     * 批量删除供应商信息表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsSupplierByIds(Long[] ids);
}
