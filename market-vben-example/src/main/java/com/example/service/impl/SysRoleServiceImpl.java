package com.example.service.impl;

import com.example.domain.SysRole;
import com.example.repository.SysRoleDao;
import com.example.service.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:58
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole save(SysRole sysRole) {
        this.sysRoleDao.save(sysRole);
        return sysRole;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole update(SysRole sysRole) {
        this.sysRoleDao.save(sysRole);
        return sysRole;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Long id) {
        this.sysRoleDao.deleteById(id);
    }

    @Override
    public Page<SysRole> listByPage(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return sysRoleDao.findAll(pageRequest);
    }

    @Override
    public List<SysRole> list() {
        return sysRoleDao.findAll();
    }

    private final SysRoleDao sysRoleDao;

    public SysRoleServiceImpl(SysRoleDao sysRoleDao) {
        this.sysRoleDao = sysRoleDao;
    }
}
