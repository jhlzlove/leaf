package com.example.service;

import com.example.domain.SysUser;
import org.springframework.data.domain.Page;

public interface SysUserService {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    SysUser register(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    SysUser delete(Long id);

    /**
     * 启用禁用
     *
     * @param id
     * @return
     */
    SysUser enabled(Long id);

    /**
     * 用户信息更新
     *
     * @param user
     * @return
     */
    SysUser update(SysUser user);

    /**
     * 分页获取
     *
     * @param page     页数
     * @param pageSize 页大小
     * @return
     */
    Page<SysUser> list(int page, int pageSize);
}
