package com.example.service;

import com.example.domain.SysOperLog;
import org.springframework.data.domain.Page;

/**
 * @author jhlz
 * @since 2022-09-11 16:48:58
 */
public interface SysOperLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return SysOperLog
     */
    public abstract SysOperLog findById(Long id);

    /**
     * 分页查询
     */
    public abstract Page<SysOperLog> listByPage(SysOperLog sysOperLog, int page, int pageSize);

    /**
     * 通过id删除数据
     *
     * @param id 主键
     * @return
     */
    public abstract void deleteById(Long id);

    /**
     * 保存数据
     *
     * @param log 数据对象
     * @return
     */
    public abstract void save(SysOperLog log);

}
