package com.example.service.impl;

import com.example.common.exception.CustomerException;
import com.example.common.property.CustomerProperties;
import com.example.domain.SysUser;
import com.example.domain.resp.LoginUserInfo;
import com.example.repository.SysUserDao;
import com.example.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jhlz
 * @time 2022/9/1 12:57
 * @desc: LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements LoginService {

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
    @Transactional(rollbackFor = CustomerException.class)
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // 获取用户
        SysUser oldUser = sysUserDao.findSysUserByUserName(user.getUsername());
        // 更新密码
        oldUser.setPassword(newPassword);
        // 更新密码加密方式
        SysUser saveUser = sysUserDao.save(oldUser);
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        // loginUserInfo.setRolesInfo(saveUser.get);
        loginUserInfo.setId(saveUser.getId());
        loginUserInfo.setUserName(saveUser.getUserName());
        loginUserInfo.setPassword(saveUser.getPassword());
        loginUserInfo.setToken(saveUser.getToken());
        loginUserInfo.setNickName(saveUser.getNickName());
        loginUserInfo.setAvatar(saveUser.getAvatar());
        loginUserInfo.setDesc(saveUser.getDesc());
        loginUserInfo.setEnabled(saveUser.getEnabled());
        return loginUserInfo;
    }

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
        SysUser sysUser = sysUserDao.findSysUserByUserName(username);
        LoginUserInfo userInfo = new LoginUserInfo();
        // 用户存在赋值
        Optional.ofNullable(sysUser).ifPresent(s -> {
            userInfo.setId(s.getId());
            userInfo.setUserName(s.getUserName());
            userInfo.setDeptId(s.getDeptId());
            userInfo.setPassword(s.getPassword());
            userInfo.setToken(s.getToken());
            userInfo.setNickName(s.getNickName());
            userInfo.setAvatar(s.getAvatar());
            userInfo.setDesc(s.getDesc());
            userInfo.setEnabled(s.getEnabled());
        });
        return userInfo;
    }

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final SysUserDao sysUserDao;

    public LoginServiceImpl(CustomerProperties property, SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

}
