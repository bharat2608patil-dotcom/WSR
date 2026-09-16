package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.WSRReport;
import com.wsr_management_service.service.WSRReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class WSRReportController {

	private final WSRReportService reportService;

	@PostMapping
	public WSRReport createReport(@RequestBody WSRReport report) {

		return reportService.save(report);
	}

	@GetMapping
	public List<WSRReport> getAllReports() {

		return reportService.getAllReports();
	}

	@GetMapping("/{id}")
	public WSRReport getReportById(@PathVariable Long id) {

		return reportService.getReportById(id);
	}

	@GetMapping("/team/{teamId}")
	public List<WSRReport> getReportsByTeam(@PathVariable Long teamId) {

		return reportService.getReportsByTeam(teamId);
	}

	@DeleteMapping("/{id}")
	public String deleteReport(@PathVariable Long id) {

		reportService.deleteReport(id);

		return "Report deleted successfully";
	}
}