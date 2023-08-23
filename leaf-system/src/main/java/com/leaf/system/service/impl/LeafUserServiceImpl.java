package com.leaf.system.service.impl;


import com.leaf.common.constant.LeafConstants;
import com.leaf.common.util.JwtUtil;
import com.leaf.system.domain.LeafRole;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.repository.LeafRoleRepository;
import com.leaf.system.repository.LeafUserRepository;
import com.leaf.system.service.LeafUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户登录信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafUserServiceImpl implements LeafUserService, UserDetailsService, UserDetailsPasswordService {
    @Override
    public Page<LeafUser> listPage(LeafUser leafUser, Pageable page) {
        return leafUserRepository.findAll(page);
    }

    @Override
    public LeafUser findById(Long id) {
        return leafUserRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUser save(LeafUser leafUser) {
        return leafUserRepository.save(leafUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafUser leafUser) {
        leafUserRepository.save(leafUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserRepository.deleteAllById(ids);
    }

    @Override
    public String login(LeafUser user) {
        // 1. 查询用户
        LeafUser leafUser = leafUserRepository.findByUsername(user.getUsername());
        // 2. 查询用户角色（权限）
        List<LeafRole> roles = roleRepository.findAllByUserId(user.getUserId());
        leafUser.setRoles(roles);
        // 3. 设置权限
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, null, leafUser.getAuthorities());
        // 4. 生成 token 返回
        Map<String, Object> payload = new HashMap<>();
        payload.put(LeafConstants.LOGIN_JWT_NAME_KEY, user.getUserId());
        String token = JwtUtil.createToken(payload);
        log.info("生成token ： {}", token);
        return token;
    }

    /**
     * 自动更新 PasswordEncoder 加密方式
     *
     * @param user        the user to modify the password for
     * @param newPassword the password to change to, encoded by the configured
     *                    {@code PasswordEncoder}
     * @return UserDetails 实现
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        boolean b = leafUserRepository.updatePasswordByUsername(user.getUsername(), newPassword);
        if (b) ((LeafUser) user).setPassword(newPassword);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return leafUserRepository.findByUsername(username);
    }

    private static final Logger log = LoggerFactory.getLogger(LeafUserServiceImpl.class);
    private final LeafUserRepository leafUserRepository;
    private final LeafRoleRepository roleRepository;

    public LeafUserServiceImpl(LeafUserRepository leafUserRepository, LeafRoleRepository roleRepository) {
        this.leafUserRepository = leafUserRepository;
        this.roleRepository = roleRepository;
    }


}

