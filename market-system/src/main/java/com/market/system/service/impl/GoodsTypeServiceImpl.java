package com.market.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.system.mapper.GoodsTypeMapper;
import com.market.system.domain.GoodsType;
import com.market.system.service.IGoodsTypeService;

/**
 * 商品类型表Service业务层处理
 * 
 * @author jhlz
 * @date 2022-07-08
 */
@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService 
{
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    /**
     * 查询商品类型表
     * 
     * @param id 商品类型表主键
     * @return 商品类型表
     */
    @Override
    public GoodsType selectGoodsTypeById(Long id)
    {
        return goodsTypeMapper.selectGoodsTypeById(id);
    }

    /**
     * 查询商品类型表列表
     * 
     * @param goodsType 商品类型表
     * @return 商品类型表
     */
    @Override
    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType)
    {
        return goodsTypeMapper.selectGoodsTypeList(goodsType);
    }

    /**
     * 新增商品类型表
     * 
     * @param goodsType 商品类型表
     * @return 结果
     */
    @Override
    public int insertGoodsType(GoodsType goodsType)
    {
        return goodsTypeMapper.insertGoodsType(goodsType);
    }

    /**
     * 修改商品类型表
     * 
     * @param goodsType 商品类型表
     * @return 结果
     */
    @Override
    public int updateGoodsType(GoodsType goodsType)
    {
        return goodsTypeMapper.updateGoodsType(goodsType);
    }

    /**
     * 批量删除商品类型表
     * 
     * @param ids 需要删除的商品类型表主键
     * @return 结果
     */
    @Override
    public int deleteGoodsTypeByIds(Long[] ids)
    {
        return goodsTypeMapper.deleteGoodsTypeByIds(ids);
    }

    /**
     * 删除商品类型表信息
     * 
     * @param id 商品类型表主键
     * @return 结果
     */
    @Override
    public int deleteGoodsTypeById(Long id)
    {
        return goodsTypeMapper.deleteGoodsTypeById(id);
    }
}
