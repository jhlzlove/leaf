package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.system.domain.GoodsRecord;
import com.market.system.mapper.GoodsRecordMapper;
import com.market.system.service.IGoodsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 记录Service业务层处理
 * 
 * @author jhlz
 * @date 2022-04-13
 */
@Service
public class GoodsRecordServiceImpl implements IGoodsRecordService
{
    @Autowired
    private GoodsRecordMapper tGoodsRecordMapper;

    /**
     * 查询记录
     * 
     * @param id 记录主键
     * @return 记录
     */
    @Override
    public GoodsRecord selectTGoodsRecordById(Long id)
    {
        return tGoodsRecordMapper.selectTGoodsRecordById(id);
    }

    /**
     * 查询记录列表
     * 
     * @param tGoodsRecord 记录
     * @return 记录
     */
    @Override
    public List<GoodsRecord> selectTGoodsRecordList(GoodsRecord tGoodsRecord)
    {
        return tGoodsRecordMapper.selectTGoodsRecordList(tGoodsRecord);
    }

    /**
     * 新增记录
     * 
     * @param tGoodsRecord 记录
     * @return 结果
     */
    @Override
    public int insertTGoodsRecord(GoodsRecord tGoodsRecord)
    {
        tGoodsRecord.setCreateTime(DateUtils.getNowDate());
        return tGoodsRecordMapper.insertTGoodsRecord(tGoodsRecord);
    }

    /**
     * 修改记录
     * 
     * @param tGoodsRecord 记录
     * @return 结果
     */
    @Override
    public int updateTGoodsRecord(GoodsRecord tGoodsRecord)
    {
        tGoodsRecord.setUpdateTime(DateUtils.getNowDate());
        return tGoodsRecordMapper.updateTGoodsRecord(tGoodsRecord);
    }

    /**
     * 批量删除记录
     * 
     * @param ids 需要删除的记录主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsRecordByIds(Long[] ids)
    {
        return tGoodsRecordMapper.deleteTGoodsRecordByIds(ids);
    }

    /**
     * 删除记录信息
     * 
     * @param id 记录主键
     * @return 结果
     */
    @Override
    public int deleteTGoodsRecordById(Long id)
    {
        return tGoodsRecordMapper.deleteTGoodsRecordById(id);
    }
}
