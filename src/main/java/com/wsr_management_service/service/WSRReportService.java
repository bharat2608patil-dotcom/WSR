package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.WSRReport;

public interface WSRReportService {

	WSRReport save(WSRReport report);

	List<WSRReport> getAllReports();

	WSRReport getReportById(Long id);

	List<WSRReport> getReportsByTeam(Long teamId);

	void deleteReport(Long id);
}