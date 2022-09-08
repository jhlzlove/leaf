package com.example.service.impl;

import com.example.common.exception.CustomerException;
import com.example.domain.SysUser;
import com.example.repository.SysUserDao;
import com.example.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * LoginService#login 中的 authenticationManager.authenticate(token)
     * 会调用这个方法从数据库获取用户信息
     *
     * @param username 用户名
     * @return UserDetails 对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户信息
        SysUser userInfo = sysUserDao.findSysUserByUserName(username);
        SysUser sysUser = Optional.ofNullable(userInfo)
                .orElseThrow(() -> new UsernameNotFoundException("该用户不存在哦~"));
        return sysUser;
    }

    /**
     * DelegatingPasswordEncoder 默认使用相对安全的加密方式
     * 在用户登录认证成功后，随 Spring Security 版本升级采用的 PasswordEncoder 自动更新密码加密方式
     *
     * @param user        the user to modify the password for
     * @param newPassword the password to change to, encoded by the configured
     *                    {@code PasswordEncoder}
     * @return
     */
    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // 获取用户
        SysUser oldUser = sysUserDao.findSysUserByUserName(user.getUsername());
        // 更新密码
        oldUser.setPassword(newPassword);
        // 更新密码加密方式
        return sysUserDao.save(oldUser);
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser register(SysUser user) {
        return sysUserDao.save(user);
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser delete(Long id) {
        SysUser user = sysUserDao.findById(id).get();
        // bit 类型: > 0 ? true : false
        user.setDelFlag(true);
        SysUser saveUser = sysUserDao.save(user);
        return saveUser;
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser enabled(Long id) {
        SysUser user = sysUserDao.findById(id).get();
        boolean flag = user.getEnabled() == true ? false : true;
        user.setEnabled(flag);
        return sysUserDao.save(user);
    }

    @Override
    public SysUser update(SysUser user) {
        SysUser sysUser = sysUserDao.findById(user.getId()).get();
        sysUser.setPassword(user.getPassword());
        sysUser.setUpdateTime(LocalDateTime.now());
        return sysUserDao.save(sysUser);
    }

    @Override
    public List<SysUser> list() {
        return sysUserDao.findAll();
    }

    private final SysUserDao sysUserDao;

    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

}
