package com.wsr_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.WSRReport;

public interface WSRReportRepository extends JpaRepository<WSRReport, Long> {

	List<WSRReport> findByTeamTeamId(Long teamId);

}