package com.market.system.mapper;

import com.market.system.domain.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    List<GoodsType> list();

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}