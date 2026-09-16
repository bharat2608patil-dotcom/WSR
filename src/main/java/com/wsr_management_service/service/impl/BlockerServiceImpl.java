package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.Blocker;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.BlockerRepository;
import com.wsr_management_service.repository.WeeklyUpdateRepository;
import com.wsr_management_service.service.BlockerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlockerServiceImpl implements BlockerService {

	private final BlockerRepository blockerRepository;
	private final WeeklyUpdateRepository weeklyUpdateRepository;

	@Override
	public Blocker save(Blocker blocker) {

		Long updateId = blocker.getWeeklyUpdate().getUpdateId();

		weeklyUpdateRepository.findById(updateId)
				.orElseThrow(() -> new ResourceNotFoundException("Weekly Update not found with id " + updateId));

		log.info("Saving blocker for updateId {}", updateId);

		return blockerRepository.save(blocker);
	}

	@Override
	public List<Blocker> getAllBlockers() {

		return blockerRepository.findAll();
	}

	@Override
	public Blocker getBlockerById(Long id) {

		return blockerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blocker not found with id " + id));
	}

	@Override
	public List<Blocker> getBlockersByWeeklyUpdate(Long updateId) {

		return blockerRepository.findByWeeklyUpdateUpdateId(updateId);
	}

	@Override
	public void deleteBlocker(Long id) {

		Blocker blocker = getBlockerById(id);

		blockerRepository.delete(blocker);
	}
}