package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.common.exception.CustomerException;
import com.example.domain.LoginUser;
import com.example.domain.SysUser;
import com.example.mapper.SysRoleMapper;
import com.example.mapper.SysUserMapper;
import com.example.mapper.SysUserRoleMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final SysUserMapper userMapper;
    private final SysUserRoleMapper userRoleMapper;
    private final SysRoleMapper roleMapper;

    @Autowired
    public UserDetailServiceImpl(SysUserMapper userMapper, SysUserRoleMapper userRoleMapper, SysRoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
        this.roleMapper = roleMapper;
    }

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 查询用户
        SysUser sysUser = userMapper.loadByUserName(username);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new UsernameNotFoundException("用户名不存在哦，请检查输入是否正确");
        }
        String permission = userMapper.selectAllPermissions(username);
        List<String> permissions = Arrays.stream(permission.split(",")).collect(Collectors.toList());
        // 生成 jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.ES512, GlobalConstants.JWT_KEY).compact();
        // 2. TODO 权限信息
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(sysUser);
        loginUser.setToken(jwtToken);
        loginUser.setRoles(permissions);
        return loginUser;
    }

    @Transactional(rollbackFor = CustomerException.class)
    public void register(SysUser user) {
        userMapper.insertSelective(user);
    }

    public SysUser getUserInfo(SysUser user) {
        SysUser userInfo = userMapper.selectByPrimaryKey(user.getId());
        return userInfo;
    }
}
