package service.impl;


import java.lang.Long;

import .entity.LeafUser;
import .service.LeafUserService;
import .repository.LeafUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * 用户登录信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafUserServiceImpl implements LeafUserService {
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
        leafUserRepository.save(leafUser);
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

    private final LeafUserRepository leafUserRepository;

    public LeafUserServiceImpl(LeafUserRepository leafUserRepository) {
        this.leafUserRepository = leafUserRepository;
    }
}

