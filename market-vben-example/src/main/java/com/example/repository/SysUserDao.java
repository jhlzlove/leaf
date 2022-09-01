package com.example.repository;

import com.example.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jhlz
 * @time 2022/9/1 8:46
 * @desc: SysUserDao
 */
public interface SysUserDao extends JpaRepository<SysUser, Long> {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public abstract SysUser findSysUserByUserName(String username);
}
