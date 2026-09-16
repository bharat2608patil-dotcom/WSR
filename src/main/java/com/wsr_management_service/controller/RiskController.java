package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.Risk;
import com.wsr_management_service.service.RiskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/risks")
@RequiredArgsConstructor
public class RiskController {

	private final RiskService riskService;

	@PostMapping
	public Risk createRisk(@RequestBody Risk risk) {

		return riskService.save(risk);
	}

	@GetMapping
	public List<Risk> getAllRisks() {

		return riskService.getAllRisks();
	}

	@GetMapping("/{id}")
	public Risk getRiskById(@PathVariable Long id) {

		return riskService.getRiskById(id);
	}

	@GetMapping("/update/{updateId}")
	public List<Risk> getRisksByUpdate(@PathVariable Long updateId) {

		return riskService.getRisksByWeeklyUpdate(updateId);
	}

	@DeleteMapping("/{id}")
	public String deleteRisk(@PathVariable Long id) {

		riskService.deleteRisk(id);

		return "Risk deleted successfully";
	}
}