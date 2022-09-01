package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.common.exception.CustomerException;
import com.example.domain.SysUser;
import com.example.repository.SysUserDao;
import com.example.service.SysUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
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
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户信息
        SysUser userInfo = sysUserDao.findSysUserByUserName(username);
        SysUser sysUser = Optional.ofNullable(userInfo)
                .orElseThrow(() -> new UsernameNotFoundException("该用户不存在哦~"));
        // 生成 jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes()).compact();
        // 设置 token
        sysUser.setToken(jwtToken);
        // TODO 设置角色权限
        return sysUser;
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class, propagation = Propagation.SUPPORTS)
    public SysUser getUserInfo(SysUser user) {
        return sysUserDao.findById(user.getId()).orElseGet(() -> new SysUser());
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser register(SysUser user) {
        return sysUserDao.save(user);
    }

    @Override
    public SysUser delete(Long id) {
        SysUser user = sysUserDao.findById(id).get();
        // bit 类型: > 0 ? true : false
        user.setDelFlag(true);
        SysUser saveUser = sysUserDao.save(user);
        return saveUser;
    }

    @Override
    public SysUser enabled(Long id) {
        SysUser user = sysUserDao.findById(id).get();
        boolean flag = user.getEnabled() == true ? false : true;
        user.setEnabled(flag);
        return sysUserDao.save(user);
    }

    private final SysUserDao sysUserDao;

    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }
}
