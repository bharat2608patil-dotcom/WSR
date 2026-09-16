package com.wsr_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.Blocker;

public interface BlockerRepository extends JpaRepository<Blocker, Long> {

	List<Blocker> findByWeeklyUpdateUpdateId(Long updateId);

}