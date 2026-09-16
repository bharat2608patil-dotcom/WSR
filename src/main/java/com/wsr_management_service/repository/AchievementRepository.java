package com.wsr_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

	List<Achievement> findByWeeklyUpdateUpdateId(Long updateId);

}