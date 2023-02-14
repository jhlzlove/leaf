package com.leaf.system.service.impl;

import com.leaf.system.domain.UserRole;
import com.leaf.system.repository.UserRoleRepository;
import com.leaf.system.service.UserRoleService;
import jakarta.persistence.NoResultException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户角色关联表(UserRole)表服务实现类
 *
 * @author jhlz
 * @since 2022-12-26 21:28:53
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public List<UserRole> listByUserId(Long userId) {
        return userRoleRepository.findAllByUserId(userId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new NoResultException("未找到该数据！"));
    }

    /**
     * 分页查询
     *
     * @param UserRole    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserRole> queryByPage(UserRole UserRole, PageRequest pageRequest) {
        long total = userRoleRepository.count(Example.of(UserRole));
        return userRoleRepository.findAll(Example.of(UserRole), pageRequest);
    }

    /**
     * 新增数据
     *
     * @param UserRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insertOrUpdate(UserRole UserRole) {
        userRoleRepository.save(UserRole);
        return UserRole;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return userRoleRepository.deleteUserRoleById(id);
    }

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository UserRoleRepository) {
        this.userRoleRepository = UserRoleRepository;
    }
}
