package com.wsr_management_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.AISummary;

public interface AISummaryRepository extends JpaRepository<AISummary, Long> {

	Optional<AISummary> findByWeeklyUpdateUpdateId(Long updateId);

}