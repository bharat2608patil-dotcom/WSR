package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.WSRReport;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.TeamRepository;
import com.wsr_management_service.repository.WSRReportRepository;
import com.wsr_management_service.service.WSRReportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WSRReportServiceImpl implements WSRReportService {

	private final WSRReportRepository reportRepository;
	private final TeamRepository teamRepository;

	@Override
	public WSRReport save(WSRReport report) {

		Long teamId = report.getTeam().getTeamId();

		teamRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found with id " + teamId));

		log.info("Generating WSR report for team {}", teamId);

		return reportRepository.save(report);
	}

	@Override
	public List<WSRReport> getAllReports() {

		return reportRepository.findAll();
	}

	@Override
	public WSRReport getReportById(Long id) {

		return reportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Report not found with id " + id));
	}

	@Override
	public List<WSRReport> getReportsByTeam(Long teamId) {

		return reportRepository.findByTeamTeamId(teamId);
	}

	@Override
	public void deleteReport(Long id) {

		WSRReport report = getReportById(id);

		reportRepository.delete(report);
	}
}