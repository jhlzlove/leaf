package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.common.exception.CustomerException;
import com.example.common.property.CustomerProperties;
import com.example.common.utils.JwtUtil;
import com.example.common.utils.SpringUtil;
import com.example.domain.SysUser;
import com.example.domain.resp.LoginUserInfo;
import com.example.repository.SysUserDao;
import com.example.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 先不想引入 redis，代替 redis 暂存一下用户信息，方便调试
     */
    private static final ConcurrentHashMap<Long, LoginUserInfo> LOCAL_USER = new ConcurrentHashMap<>();

    @Override
    @Transactional(rollbackFor = CustomerException.class)
    public SysUser saveOrUpdate(SysUser user) {
        SysUser saveOrUpdateUser = sysUserDao.findById(user.getId()).orElseGet(SysUser::new);
        BeanUtils.copyProperties(user, saveOrUpdateUser, SpringUtil.getNullPropertyNames(user));
        saveOrUpdateUser.setUpdateTime(LocalDateTime.now());
        return sysUserDao.save(saveOrUpdateUser);
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
        SysUser user = sysUserDao.findById(id)
                .orElseThrow(() -> new CustomerException(HttpStatus.NOT_FOUND));
        boolean flag = user.getEnabled() == true ? false : true;
        user.setEnabled(flag);
        return sysUserDao.save(user);
    }

    @Override
    public Page<SysUser> list(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return sysUserDao.findAll(pageRequest);
    }


    @Override
    public LoginUserInfo login(SysUser user) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), null);
        // 认证
        Authentication authenticate = authenticationManager.authenticate(token);
        LoginUserInfo userInfo = new LoginUserInfo();

        Optional.ofNullable(authenticate).ifPresent(auth -> {
            // 获取用户
            LoginUserInfo loginUser = (LoginUserInfo) auth.getPrincipal();
            // 生成 jwt
            Map<String, Object> claims = new HashMap<>();
            claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
            String jwtToken = property.getTOKEN_PREFIX() + JwtUtil.createToken(LocalDateTime.now().plusMinutes(10), claims);

            // 模拟存入 redis
            loginUser.setToken(jwtToken);
            LOCAL_USER.put(loginUser.getId(), loginUser);

            userInfo.setUserName(loginUser.getUsername())
                    .setNickName(loginUser.getNickName())
                    .setId(loginUser.getId())
                    .setToken(jwtToken);
        });
        return userInfo;
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class, propagation = Propagation.SUPPORTS)
    public LoginUserInfo getUserInfo() {
        return Optional.ofNullable(LOCAL_USER.get(4L)).orElseGet(() -> new LoginUserInfo());
    }

    private final SysUserDao sysUserDao;

    private final AuthenticationManager authenticationManager;
    private final CustomerProperties property;

    public SysUserServiceImpl(AuthenticationManager authenticationManager, SysUserDao sysUserDao, CustomerProperties property) {
        this.property = property;
        this.authenticationManager = authenticationManager;
        this.sysUserDao = sysUserDao;
    }

}
