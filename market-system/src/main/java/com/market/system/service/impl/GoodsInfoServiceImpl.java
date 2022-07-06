package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.common.utils.StringUtils;
import com.market.system.domain.GoodsInfo;
import com.market.system.domain.GoodsType;
import com.market.system.mapper.GoodsInfoMapper;
import com.market.system.service.IGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品信息Service业务层处理
 *
 * @author jhlz
 * @date 2022-07-06
 */
@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    @Override
    public GoodsInfo selectGoodsInfoById(Long id) {
        return goodsInfoMapper.selectGoodsInfoById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param goodsInfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<GoodsInfo> selectGoodsInfoList(GoodsInfo goodsInfo) {
        return goodsInfoMapper.selectGoodsInfoList(goodsInfo);
    }

    /**
     * 新增商品信息
     *
     * @param goodsInfo 商品信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertGoodsInfo(GoodsInfo goodsInfo) {
        goodsInfo.setCreateTime(DateUtils.getNowDate());
        int rows = goodsInfoMapper.insertGoodsInfo(goodsInfo);
        insertGoodsType(goodsInfo);
        return rows;
    }

    /**
     * 修改商品信息
     *
     * @param goodsInfo 商品信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateGoodsInfo(GoodsInfo goodsInfo) {
        goodsInfo.setUpdateTime(DateUtils.getNowDate());
        goodsInfoMapper.deleteGoodsTypeByTypeCode(goodsInfo.getId());
        insertGoodsType(goodsInfo);
        return goodsInfoMapper.updateGoodsInfo(goodsInfo);
    }

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteGoodsInfoByIds(Long[] ids) {
        goodsInfoMapper.deleteGoodsTypeByTypeCodes(ids);
        return goodsInfoMapper.deleteGoodsInfoByIds(ids);
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteGoodsInfoById(Long id) {
        goodsInfoMapper.deleteGoodsTypeByTypeCode(id);
        return goodsInfoMapper.deleteGoodsInfoById(id);
    }

    /**
     * 新增商品类型表信息
     *
     * @param goodsInfo 商品信息对象
     */
    public void insertGoodsType(GoodsInfo goodsInfo) {
        List<GoodsType> goodsTypeList = goodsInfo.getGoodsTypeList();
        Long id = goodsInfo.getId();
        if (StringUtils.isNotNull(goodsTypeList)) {
            List<GoodsType> list = new ArrayList<GoodsType>();
            for (GoodsType goodsType : goodsTypeList) {
                goodsType.setTypeCode(String.valueOf(id));
                list.add(goodsType);
            }
            if (list.size() > 0) {
                goodsInfoMapper.batchGoodsType(list);
            }
        }
    }
}
