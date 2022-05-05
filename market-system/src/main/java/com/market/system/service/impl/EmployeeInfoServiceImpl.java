package com.market.system.service.impl;

import com.market.common.utils.DateUtils;
import com.market.system.domain.EmployeeInfo;
import com.market.system.mapper.EmployeeInfoMapper;
import com.market.system.service.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * 员工信息Service业务层处理
 *
 * @author jhlz
 * @date 2022-04-13
 */
@Service
public class EmployeeInfoServiceImpl implements IEmployeeInfoService {
    @Autowired
    private EmployeeInfoMapper tEmployeeInfoMapper;

    /**
     * 查询员工信息
     *
     * @param id 员工信息主键
     * @return 员工信息
     */
    @Override
    public EmployeeInfo selectTEmployeeInfoById(Long id) {
        return tEmployeeInfoMapper.selectTEmployeeInfoById(id);
    }

    /**
     * 查询员工信息列表
     *
     * @param tEmployeeInfo 员工信息
     * @return 员工信息
     */
    @Override
    public List<EmployeeInfo> selectTEmployeeInfoList(EmployeeInfo tEmployeeInfo) {
        return tEmployeeInfoMapper.selectTEmployeeInfoList(tEmployeeInfo);
    }

    /**
     * 新增员工信息
     *
     * @param employeeInfo 员工信息
     * @return 结果
     */
    @Override
    public int insertTEmployeeInfo(EmployeeInfo employeeInfo) {
        employeeInfo.setEmployeeCode(Instant.now().getEpochSecond() + "");
        employeeInfo.setCreateTime(DateUtils.getNowDate());
        return tEmployeeInfoMapper.insertTEmployeeInfo(employeeInfo);
    }

    /**
     * 修改员工信息
     *
     * @param tEmployeeInfo 员工信息
     * @return 结果
     */
    @Override
    public int updateTEmployeeInfo(EmployeeInfo tEmployeeInfo) {
        tEmployeeInfo.setUpdateTime(DateUtils.getNowDate());
        return tEmployeeInfoMapper.updateTEmployeeInfo(tEmployeeInfo);
    }

    /**
     * 批量删除员工信息
     *
     * @param ids 需要删除的员工信息主键
     * @return 结果
     */
    @Override
    public int deleteTEmployeeInfoByIds(Long[] ids) {
        return tEmployeeInfoMapper.deleteTEmployeeInfoByIds(ids);
    }

    /**
     * 删除员工信息信息
     *
     * @param id 员工信息主键
     * @return 结果
     */
    @Override
    public int deleteTEmployeeInfoById(Long id) {
        return tEmployeeInfoMapper.deleteTEmployeeInfoById(id);
    }
}
