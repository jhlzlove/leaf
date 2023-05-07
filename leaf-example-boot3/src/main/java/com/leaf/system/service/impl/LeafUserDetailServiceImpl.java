package service.impl;


import java.lang.Long;

import .entity.LeafUserDetail;
import .service.LeafUserDetailService;
import .repository.LeafUserDetailRepository;
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
 * 用户信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafUserDetailServiceImpl implements LeafUserDetailService {
    @Override
    public Page<LeafUserDetail> listPage(LeafUserDetail leafUserDetail, Pageable page) {
        return leafUserDetailRepository.findAll(page);
    }

    @Override
    public LeafUserDetail findById(Long id) {
        return leafUserDetailRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUserDetail save(LeafUserDetail leafUserDetail) {
        leafUserDetailRepository.save(leafUserDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafUserDetail leafUserDetail) {
        leafUserDetailRepository.save(leafUserDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserDetailRepository.deleteAllById(ids);
    }

    private final LeafUserDetailRepository leafUserDetailRepository;

    public LeafUserDetailServiceImpl(LeafUserDetailRepository leafUserDetailRepository) {
        this.leafUserDetailRepository = leafUserDetailRepository;
    }
}

