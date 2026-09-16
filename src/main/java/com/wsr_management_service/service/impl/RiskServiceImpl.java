package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.Risk;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.RiskRepository;
import com.wsr_management_service.repository.WeeklyUpdateRepository;
import com.wsr_management_service.service.RiskService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiskServiceImpl implements RiskService {

	private final RiskRepository riskRepository;
	private final WeeklyUpdateRepository weeklyUpdateRepository;

	@Override
	public Risk save(Risk risk) {

		Long updateId = risk.getWeeklyUpdate().getUpdateId();

		weeklyUpdateRepository.findById(updateId)
				.orElseThrow(() -> new ResourceNotFoundException("Weekly Update not found with id " + updateId));

		log.info("Saving risk for updateId {}", updateId);

		return riskRepository.save(risk);
	}

	@Override
	public List<Risk> getAllRisks() {

		return riskRepository.findAll();
	}

	@Override
	public Risk getRiskById(Long id) {

		return riskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Risk not found with id " + id));
	}

	@Override
	public List<Risk> getRisksByWeeklyUpdate(Long updateId) {

		return riskRepository.findByWeeklyUpdateUpdateId(updateId);
	}

	@Override
	public void deleteRisk(Long id) {

		Risk risk = getRiskById(id);

		riskRepository.delete(risk);
	}
}