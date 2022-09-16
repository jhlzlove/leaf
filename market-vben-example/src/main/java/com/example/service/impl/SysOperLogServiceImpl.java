package com.example.service.impl;

import com.example.domain.SysOperLog;
import com.example.repository.SysOperLogDao;
import com.example.service.SysOperLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author jhlz
 * @since 2022-09-11 16:49:00
 */
@Service
public class SysOperLogServiceImpl implements SysOperLogService {

    @Override
    public SysOperLog findById(Long id) {
        return this.sysOperLogDao.findById(id).get();
    }

    @Override
    public Page<SysOperLog> listByPage(SysOperLog sysOperLog, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return sysOperLogDao.findAll(pageRequest);
    }

    @Override
    public void deleteById(Long id) {
        this.sysOperLogDao.deleteById(id);
    }

    @Override
    public void save(SysOperLog log) {
        this.sysOperLogDao.save(log);
    }

    private final SysOperLogDao sysOperLogDao;

    public SysOperLogServiceImpl(SysOperLogDao sysOperLogDao) {
        this.sysOperLogDao = sysOperLogDao;
    }
}
