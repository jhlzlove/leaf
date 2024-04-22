package com.leaf.service.impl;

import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import com.leaf.domain.LoginUser;
import com.leaf.domain.Tables;
import com.leaf.repository.LeafUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring Security UserDetailService、UserDetailsPasswordService 的实现类
 * 两个接口分别负责登录认证、密码加密方式的自动更新
 *
 * @author jhlz
 * @version 1.0.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService {

    private final LeafUserRepository leafUserRepository;

    public UserDetailServiceImpl(LeafUserRepository leafUserRepository) {
        this.leafUserRepository = leafUserRepository;
    }

    LeafUserTable userTable = Tables.LEAF_USER_TABLE;

    /**
     * 自动更新 PasswordEncoder 加密方式
     *
     * @param user        the user to modify the password for
     * @param newPassword the password to change to, encoded by the configured
     *                    {@code PasswordEncoder}
     * @return UserDetails 实现
     */
    @Override
    @Transactional
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        Integer result = leafUserRepository.sql().createUpdate(userTable)
                .set(userTable.password(), newPassword)
                .where(userTable.username().eq(user.getUsername()))
                .execute();
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<LeafUser> list = leafUserRepository
                .sql().createQuery(userTable)
                .where(userTable.username().eq(username))
                .select(userTable)
                .execute();
        LeafUser user = list.getFirst();
        return new LoginUser(
                new LoginUser.UserRecord(
                        user.username(),
                        user.password(),
                        user.status()
                ),
                List.of("admin")
        );
    }
}
