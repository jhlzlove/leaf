package com.market.system.mapper;

import com.market.system.domain.GoodsRecord;

import java.util.List;

/**
 * 记录Mapper接口
 *
 * @author jhlz
 * @date 2022-04-13
 */
public interface GoodsRecordMapper {
    /**
     * 查询记录
     *
     * @param id 记录主键
     * @return 记录
     */
    public GoodsRecord selectTGoodsRecordById(Long id);

    /**
     * 查询记录列表
     *
     * @param tGoodsRecord 记录
     * @return 记录集合
     */
    public List<GoodsRecord> selectTGoodsRecordList(GoodsRecord tGoodsRecord);

    /**
     * 新增记录
     *
     * @param tGoodsRecord 记录
     * @return 结果
     */
    public int insertTGoodsRecord(GoodsRecord tGoodsRecord);

    /**
     * 修改记录
     *
     * @param tGoodsRecord 记录
     * @return 结果
     */
    public int updateTGoodsRecord(GoodsRecord tGoodsRecord);

    /**
     * 删除记录
     *
     * @param id 记录主键
     * @return 结果
     */
    public int deleteTGoodsRecordById(Long id);

    /**
     * 批量删除记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTGoodsRecordByIds(Long[] ids);
}
