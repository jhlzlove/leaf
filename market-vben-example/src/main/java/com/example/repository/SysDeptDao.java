package com.example.repository;

import com.example.domain.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
public interface SysDeptDao extends JpaRepository<SysDept, Long> {

}
