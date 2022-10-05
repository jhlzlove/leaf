package com.example.service.impl;

import com.example.common.utils.SpringUtil;
import com.example.domain.SysDept;
import com.example.repository.SysDeptDao;
import com.example.service.SysDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Override
    public SysDept findById(Long deptId) {
        return deptDao.findById(deptId).orElseGet(SysDept::new);
    }

    /**
     * 添加或修改数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysDept saveOrUpdate(SysDept sysDept) {
        SysDept updateDept = deptDao.findById(sysDept.getId()).orElseGet(SysDept::new);
        BeanUtils.copyProperties(sysDept, updateDept, SpringUtil.getNullPropertyNames(sysDept));
        updateDept.setUpdateTime(LocalDateTime.now());
        return deptDao.save(updateDept);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Long id) {
        this.deptDao.deleteById(id);
    }

    @Override
    public List<SysDept> listDeptTree(final String deptName, final Boolean status) {
        List<SysDept> allList = deptDao.findAll();
        List<SysDept> deptList = buildDeptTree(allList, 0L);

        // 不查询就直接返回所有结果列表
        if (ObjectUtils.isEmpty(deptName) && ObjectUtils.isEmpty(status)) {
            return deptList;
        }
        /* 要什么效率，程序管跑、功能实现才是第一步，优化要慢慢来 */
        // 两项都输入查询走这个
        if (!ObjectUtils.isEmpty(deptName) && !ObjectUtils.isEmpty(status)) {
            return deptList.stream()
                    .filter(a -> ObjectUtils.nullSafeEquals(a.getDeptName(), deptName) &&
                            ObjectUtils.nullSafeEquals(a.getStatus(), status))
                    .collect(Collectors.toList());
        } else if (!ObjectUtils.isEmpty(deptName)) {
            // 只查名字就根据这个
            return deptList.stream()
                    .filter(a -> ObjectUtils.nullSafeEquals(a.getDeptName(), deptName))
                    .collect(Collectors.toList());
        } else if (!ObjectUtils.isEmpty(status)) {
            // 只查状态就走这个
            return deptList.stream()
                    .filter(a -> ObjectUtils.nullSafeEquals(a.getStatus(), status))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 构建部门树
     */
    public List<SysDept> buildDeptTree(final List<SysDept> deptList, Long pid) {
        List<SysDept> result = new ArrayList<>();
        deptList.stream().forEach(dept -> {
            if (Objects.equals(dept.getParentId(), pid)) {
                dept.setChildren(buildDeptTree(deptList, dept.getId()));
                result.add(dept);
            }
        });
        return result;
    }

    private final SysDeptDao deptDao;

    public SysDeptServiceImpl(SysDeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
