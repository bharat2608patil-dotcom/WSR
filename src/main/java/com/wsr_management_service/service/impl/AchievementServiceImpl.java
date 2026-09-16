package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.Achievement;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.AchievementRepository;
import com.wsr_management_service.repository.WeeklyUpdateRepository;
import com.wsr_management_service.service.AchievementService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AchievementServiceImpl implements AchievementService {

	private final AchievementRepository achievementRepository;
	private final WeeklyUpdateRepository weeklyUpdateRepository;

	@Override
	public Achievement save(Achievement achievement) {
		Long updateId = achievement.getWeeklyUpdate().getUpdateId();
		weeklyUpdateRepository.findById(updateId)
				.orElseThrow(() -> new ResourceNotFoundException("Weekly Update not found with id " + updateId));

		return achievementRepository.save(achievement);

	}

	@Override
	public List<Achievement> getAllAchievements() {

		return achievementRepository.findAll();
	}

	@Override
	public Achievement getAchievementById(Long id) {

		return achievementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Achievement not found with id " + id));
	}

	@Override
	public List<Achievement> getAchievementsByWeeklyUpdate(Long updateId) {

		return achievementRepository.findByWeeklyUpdateUpdateId(updateId);
	}

	@Override
	public void deleteAchievement(Long id) {

		Achievement achievement = getAchievementById(id);

		achievementRepository.delete(achievement);
	}
}