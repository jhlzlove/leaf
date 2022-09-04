package com.example.repository;

import com.example.domain.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jhlz
 * @time 2022/8/31 19:52
 * @desc: SysMenuDao
 */
public interface SysMenuDao extends JpaRepository<SysMenu, Long> {

}
