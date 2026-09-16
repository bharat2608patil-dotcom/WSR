package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.Achievement;

public interface AchievementService {

	Achievement save(Achievement achievement);

	List<Achievement> getAllAchievements();

	Achievement getAchievementById(Long id);

	List<Achievement> getAchievementsByWeeklyUpdate(Long updateId);

	void deleteAchievement(Long id);
}