package com.example.system.service;

import com.example.system.domain.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 账户角色关联表(UserRole)表服务接口
 *
 * @author jhlz
 * @since 2022-12-26 21:28:53
 */
public interface UserRoleService {

    /**
     * 根据用户 id 获取数据
     */
    List<UserRole> listByUserId(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param UserRole    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<UserRole> queryByPage(UserRole UserRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param UserRole 实例对象
     * @return 实例对象
     */
    UserRole insertOrUpdate(UserRole UserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
