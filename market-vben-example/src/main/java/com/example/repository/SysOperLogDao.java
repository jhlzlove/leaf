package com.example.repository;

import com.example.domain.SysOperLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jhlz
 * @since 2022-09-11 16:48:56
 */
public interface SysOperLogDao extends JpaRepository<SysOperLog, Long> {

}
