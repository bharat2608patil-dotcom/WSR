package com.wsr_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.Risk;

public interface RiskRepository
        extends JpaRepository<Risk, Long> {

    List<Risk> findByWeeklyUpdateUpdateId(Long updateId);

}