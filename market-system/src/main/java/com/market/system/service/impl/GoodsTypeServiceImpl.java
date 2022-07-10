package com.market.system.service.impl;

import com.market.common.core.domain.TreeSelect;
import com.market.common.utils.StringUtils;
import com.market.system.domain.GoodsType;
import com.market.system.mapper.GoodsTypeMapper;
import com.market.system.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品类型表Service业务层处理
 *
 * @author jhlz
 * @date 2022-07-08
 */
@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    /**
     * 查询商品类型表
     *
     * @param id 商品类型表主键
     * @return 商品类型表
     */
    @Override
    public GoodsType selectGoodsTypeById(Long id) {
        return goodsTypeMapper.selectGoodsTypeById(id);
    }

    /**
     * 查询商品类型表列表
     *
     * @param goodsType 商品类型表
     * @return 商品类型表
     */
    @Override
    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType) {
        return goodsTypeMapper.selectGoodsTypeList(goodsType);
    }

    /**
     * 新增商品类型表
     *
     * @param goodsType 商品类型表
     * @return 结果
     */
    @Override
    public int insertGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.insertGoodsType(goodsType);
    }

    /**
     * 修改商品类型表
     *
     * @param goodsType 商品类型表
     * @return 结果
     */
    @Override
    public int updateGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.updateGoodsType(goodsType);
    }

    /**
     * 批量删除商品类型表
     *
     * @param ids 需要删除的商品类型表主键
     * @return 结果
     */
    @Override
    public int deleteGoodsTypeByIds(Long[] ids) {
        return goodsTypeMapper.deleteGoodsTypeByIds(ids);
    }

    /**
     * 删除商品类型表信息
     *
     * @param id 商品类型表主键
     * @return 结果
     */
    @Override
    public int deleteGoodsTypeById(Long id) {
        return goodsTypeMapper.deleteGoodsTypeById(id);
    }

    @Override
    public List<GoodsType> selectTypeList(List<GoodsType> goodsType) {
        List<GoodsType> typeTree = buildTypeTree(goodsType);
        return typeTree.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param goodsTypes 部门列表
     * @return 树结构列表
     */
    @Override
    public List<GoodsType> buildTypeTree(List<GoodsType> goodsTypes) {
        List<GoodsType> returnList = new ArrayList<GoodsType>();
        List<Long> tempList = new ArrayList<Long>();
        for (GoodsType type : goodsTypes) {
            tempList.add(type.getTypeCode());
        }
        for (Iterator<GoodsType> iterator = goodsTypes.iterator(); iterator.hasNext(); ) {
            GoodsType type = (GoodsType) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(type.getpCode())) {
                recursionFn(goodsTypes, type);
                returnList.add(type);
            }
        }
        if (returnList.isEmpty()) {
            returnList = goodsTypes;
        }
        return returnList;
    }

    @Override
    public List<TreeSelect> buildTypeTreeSelect(List<GoodsType> types) {
        return null;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<GoodsType> list, GoodsType t) {
        // 得到子节点列表
        List<GoodsType> childList = getChildList(list, t);
        t.setChildren(childList);
        for (GoodsType tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<GoodsType> getChildList(List<GoodsType> list, GoodsType t) {
        List<GoodsType> tlist = new ArrayList<GoodsType>();
        Iterator<GoodsType> it = list.iterator();
        while (it.hasNext()) {
            GoodsType n = (GoodsType) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getTypeCode().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<GoodsType> list, GoodsType t) {
        return getChildList(list, t).size() > 0;
    }


}
