package com.market.system.service;

import com.market.system.domain.EmployeeInfo;

import java.util.List;

/**
 * 员工信息Service接口
 *
 * @author jhlz
 * @date 2022-04-13
 */
public interface IEmployeeInfoService {
    /**
     * 查询员工信息
     *
     * @param id 员工信息主键
     * @return 员工信息
     */
    public EmployeeInfo selectTEmployeeInfoById(Long id);

    /**
     * 查询员工信息列表
     *
     * @param tEmployeeInfo 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeInfo> selectTEmployeeInfoList(EmployeeInfo tEmployeeInfo);

    /**
     * 新增员工信息
     *
     * @param tEmployeeInfo 员工信息
     * @return 结果
     */
    public int insertTEmployeeInfo(EmployeeInfo tEmployeeInfo);

    /**
     * 修改员工信息
     *
     * @param tEmployeeInfo 员工信息
     * @return 结果
     */
    public int updateTEmployeeInfo(EmployeeInfo tEmployeeInfo);

    /**
     * 批量删除员工信息
     *
     * @param ids 需要删除的员工信息主键集合
     * @return 结果
     */
    public int deleteTEmployeeInfoByIds(Long[] ids);

    /**
     * 删除员工信息信息
     *
     * @param id 员工信息主键
     * @return 结果
     */
    public int deleteTEmployeeInfoById(Long id);
}
