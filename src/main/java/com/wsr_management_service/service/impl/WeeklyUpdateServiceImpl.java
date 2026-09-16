package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.WeeklyUpdate;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.WeeklyUpdateRepository;
import com.wsr_management_service.service.WeeklyUpdateService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeeklyUpdateServiceImpl implements WeeklyUpdateService {

	private final WeeklyUpdateRepository weeklyUpdateRepository;

	@Override
	public WeeklyUpdate save(WeeklyUpdate weeklyUpdate) {

		log.info("Saving weekly update for user {}", weeklyUpdate.getUser().getUserId());

		return weeklyUpdateRepository.save(weeklyUpdate);
	}

	@Override
	public List<WeeklyUpdate> getAllUpdates() {

		return weeklyUpdateRepository.findAll();
	}

	@Override
	public WeeklyUpdate getUpdateById(Long id) {

		return weeklyUpdateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Weekly Update not found with id " + id));
	}

	@Override
	public List<WeeklyUpdate> getUpdatesByUser(Long userId) {

		return weeklyUpdateRepository.findByUserUserId(userId);
	}

	@Override
	public List<WeeklyUpdate> getUpdatesByProject(Long projectId) {

		return weeklyUpdateRepository.findByProjectProjectId(projectId);
	}

	@Override
	public void deleteUpdate(Long id) {

		WeeklyUpdate update = getUpdateById(id);

		weeklyUpdateRepository.delete(update);
	}
}