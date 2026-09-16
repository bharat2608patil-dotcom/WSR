package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.AISummary;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.AISummaryRepository;
import com.wsr_management_service.repository.WeeklyUpdateRepository;
import com.wsr_management_service.service.AISummaryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AISummaryServiceImpl implements AISummaryService {

	private final AISummaryRepository aiSummaryRepository;
	private final WeeklyUpdateRepository weeklyUpdateRepository;

	@Override
	public AISummary save(AISummary aiSummary) {

		Long updateId = aiSummary.getWeeklyUpdate().getUpdateId();

		weeklyUpdateRepository.findById(updateId)
				.orElseThrow(() -> new ResourceNotFoundException("Weekly Update not found with id " + updateId));

		log.info("Generating AI Summary for update {}", updateId);

		return aiSummaryRepository.save(aiSummary);
	}

	@Override
	public List<AISummary> getAllSummaries() {

		return aiSummaryRepository.findAll();
	}

	@Override
	public AISummary getSummaryById(Long id) {

		return aiSummaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AI Summary not found with id " + id));
	}

	@Override
	public AISummary getSummaryByUpdateId(Long updateId) {

		return aiSummaryRepository.findByWeeklyUpdateUpdateId(updateId)
				.orElseThrow(() -> new ResourceNotFoundException("AI Summary not found for update " + updateId));
	}

	@Override
	public void deleteSummary(Long id) {

		AISummary summary = getSummaryById(id);

		aiSummaryRepository.delete(summary);
	}
}