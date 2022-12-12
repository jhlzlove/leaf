package com.example.system.service;

import com.example.system.domain.User;
import org.springframework.data.domain.Page;

/**
 * 用户信息表(User)表服务接口
 *
 * @author jhlz
 * @since 2022-12-11 13:46:31
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 分页查询
     *
     * @param user      筛选条件
     * @param pageIndex 第几页
     * @param pageSize  每页记录数
     * @return 查询结果
     */
    Page<User> queryByPage(User user, int pageIndex, int pageSize);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insertOrUpdate(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Long id);

}
