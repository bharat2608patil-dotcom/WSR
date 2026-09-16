package com.wsr_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.WeeklyUpdate;

public interface WeeklyUpdateRepository
        extends JpaRepository<WeeklyUpdate, Long> {

    List<WeeklyUpdate> findByUserUserId(Long userId);

    List<WeeklyUpdate> findByProjectProjectId(Long projectId);

}