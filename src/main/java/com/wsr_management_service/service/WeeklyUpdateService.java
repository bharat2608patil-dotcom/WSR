package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.WeeklyUpdate;

public interface WeeklyUpdateService {

	WeeklyUpdate save(WeeklyUpdate weeklyUpdate);

	List<WeeklyUpdate> getAllUpdates();

	WeeklyUpdate getUpdateById(Long id);

	List<WeeklyUpdate> getUpdatesByUser(Long userId);

	List<WeeklyUpdate> getUpdatesByProject(Long projectId);

	void deleteUpdate(Long id);
}