package com.example.service.impl;

import com.example.common.exception.CustomerException;
import com.example.domain.SysUser;
import com.example.repository.SysUserDao;
import com.example.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser register(SysUser user) {
        return sysUserDao.save(user);
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser delete(Long id) {
        SysUser user = sysUserDao.findById(id)
                .orElseThrow(() -> new CustomerException(HttpStatus.NOT_FOUND));
        // bit 类型: > 0 ? true : false
        user.setDelFlag(true);
        SysUser saveUser = sysUserDao.save(user);
        return saveUser;
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser enabled(Long id) {
        SysUser user = sysUserDao.findById(id).orElseGet(() -> new SysUser());
        boolean flag = user.getEnabled() == true ? false : true;
        user.setEnabled(flag);
        return sysUserDao.save(user);
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser update(SysUser user) {
        SysUser sysUser = sysUserDao.findById(user.getId()).get();
        sysUser.setPassword(user.getPassword());
        sysUser.setUpdateTime(LocalDateTime.now());
        return sysUserDao.save(sysUser);
    }

    @Override
    public Page<SysUser> list(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return sysUserDao.findAll(pageRequest);
    }

    private final SysUserDao sysUserDao;

    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

}
