package com.example.service.impl;

import com.example.domain.SysDept;
import com.example.repository.SysDeptDao;
import com.example.service.SysDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysDept findById(Long id) {
        return this.sysDeptDao.findById(id).get();
    }

    /**
     * 分页查询
     *
     * @param sysDept     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysDept> findByPage(SysDept sysDept, PageRequest pageRequest) {
        // long total = this.sysDeptDao.count(sysDept);
        return null;
    }

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysDept save(SysDept sysDept) {
        this.sysDeptDao.save(sysDept);
        return sysDept;
    }

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysDept update(SysDept sysDept) {
        this.sysDeptDao.save(sysDept);
        return sysDept;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Long id) {
        this.sysDeptDao.deleteById(id);
    }

    @Override
    public List<SysDept> list() {
        return sysDeptDao.findAll();
    }

    private final SysDeptDao sysDeptDao;

    public SysDeptServiceImpl(SysDeptDao sysDeptDao) {
        this.sysDeptDao = sysDeptDao;
    }
}
