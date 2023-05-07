package service.impl;


import java.lang.Long;

import .entity.LeafMenu;
import .service.LeafMenuService;
import .repository.LeafMenuRepository;
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
 * 菜单表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Service
public class LeafMenuServiceImpl implements LeafMenuService {
    @Override
    public Page<LeafMenu> listPage(LeafMenu leafMenu, Pageable page) {
        return leafMenuRepository.findAll(page);
    }

    @Override
    public LeafMenu findById(Long id) {
        return leafMenuRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafMenu save(LeafMenu leafMenu) {
        leafMenuRepository.save(leafMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafMenu leafMenu) {
        leafMenuRepository.save(leafMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafMenuRepository.deleteAllById(ids);
    }

    private final LeafMenuRepository leafMenuRepository;

    public LeafMenuServiceImpl(LeafMenuRepository leafMenuRepository) {
        this.leafMenuRepository = leafMenuRepository;
    }
}

