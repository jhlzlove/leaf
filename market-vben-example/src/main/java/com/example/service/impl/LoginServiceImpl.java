package com.example.service.impl;

import com.example.common.constants.GlobalConstants;
import com.example.common.exception.CustomerException;
import com.example.common.properties.CustomerProperties;
import com.example.common.utils.JwtUtil;
import com.example.domain.SysUser;
import com.example.domain.resp.LoginUserInfo;
import com.example.repository.SysUserDao;
import com.example.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jhlz
 * @time 2022/9/1 12:57
 * @desc: LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 先不想引入 redis，代替 redis 暂存一下用户信息，方便调试
     */
    private static final ConcurrentHashMap<Long, SysUser> LOCAL_USER = new ConcurrentHashMap<>();

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
        Optional.ofNullable(sysUser).ifPresent(s -> {
            userInfo.setUserName(s.getUserName())
                    .setNickName(s.getNickName())
                    .setAvatar(s.getAvatar());
        });
        return userInfo;
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
            SysUser loginUser = (SysUser) auth.getPrincipal();
            // 生成 jwt
            Map<String, Object> claims = new HashMap<>();
            claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
            String jwtToken = property.getTOKEN_PREFIX() + JwtUtil.createToken(claims);

            // 模拟存入 redis
            loginUser.setToken(jwtToken);
            LOCAL_USER.put(loginUser.getId(), loginUser);

            userInfo.setUserName(loginUser.getUserName())
                    .setNickName(loginUser.getNickName())
                    .setId(loginUser.getId())
                    .setToken(jwtToken);
        });
        return userInfo;
    }

    @Override
    @Transactional(rollbackFor = CustomerException.class, propagation = Propagation.SUPPORTS)
    public SysUser getUserInfo() {
        return Optional.ofNullable(LOCAL_USER.get(4L)).orElseGet(() -> new SysUser());
    }

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final AuthenticationManager authenticationManager;
    private final CustomerProperties property;

    private final SysUserDao sysUserDao;

    public LoginServiceImpl(AuthenticationManager authenticationManager, CustomerProperties property, SysUserDao sysUserDao) {
        this.authenticationManager = authenticationManager;
        this.property = property;
        this.sysUserDao = sysUserDao;
    }

}
