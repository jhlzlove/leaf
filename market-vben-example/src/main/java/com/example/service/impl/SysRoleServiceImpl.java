package com.example.service.impl;

import com.example.common.exception.CustomerException;
import com.example.common.utils.SpringUtil;
import com.example.domain.SysRole;
import com.example.repository.SysRoleDao;
import com.example.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:58
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysRole saveOrUpdate(SysRole sysRole) {
        SysRole saveOrUpdateRole = sysRoleDao.findById(sysRole.getId()).orElseGet(SysRole::new);
        BeanUtils.copyProperties(sysRole, saveOrUpdateRole, SpringUtil.getNullPropertyNames(sysRole));
        return sysRoleDao.save(saveOrUpdateRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = CustomerException.class)
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
