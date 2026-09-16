package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.Blocker;

public interface BlockerService {

	Blocker save(Blocker blocker);

	List<Blocker> getAllBlockers();

	Blocker getBlockerById(Long id);

	List<Blocker> getBlockersByWeeklyUpdate(Long updateId);

	void deleteBlocker(Long id);
}