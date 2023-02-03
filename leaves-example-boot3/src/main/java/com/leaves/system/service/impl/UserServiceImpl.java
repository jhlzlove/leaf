package com.leaves.system.service.impl;

import com.leaves.common.utils.SpringUtil;
import com.leaves.system.domain.User;
import com.leaves.system.repository.UserRepository;
import com.leaves.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 用户信息表(User)表服务实现类
 *
 * @author jhlz
 * @since 2022-12-11 13:46:31
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return userRepository.findById(id).orElseGet(User::new);
    }

    @Override
    public User queryByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    /**
     * 分页查询
     *
     * @param user      筛选条件
     * @param pageIndex 第几页
     * @param pageSize  每页记录数
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, int pageIndex, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        Page<User> all = userRepository.findAll(pageRequest);
        log.info("{}", all);
        log.info("总数：{}", all.getTotalElements());
        return new PageImpl<>(userRepository.findAll(), pageRequest, all.getTotalElements());
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insertOrUpdate(User user) {
        Optional<User> oldUser = userRepository.findById(user.getId());
        // 没有找到直接保存，找到就更新
        if (oldUser.isEmpty()) {
            return userRepository.save(user);
        } else {
            User newUser = oldUser.get();
            BeanUtils.copyProperties(user, newUser, SpringUtil.getNullPropertyNames(user));
            newUser.setUpdateTime(LocalDateTime.now());
            return userRepository.save(newUser);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     */
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
