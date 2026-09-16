package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.WeeklyUpdate;
import com.wsr_management_service.service.WeeklyUpdateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/weekly-updates")
@RequiredArgsConstructor
public class WeeklyUpdateController {

	private final WeeklyUpdateService weeklyUpdateService;

	@PostMapping
	public WeeklyUpdate createUpdate(@RequestBody WeeklyUpdate weeklyUpdate) {

		return weeklyUpdateService.save(weeklyUpdate);
	}

	@GetMapping
	public List<WeeklyUpdate> getAllUpdates() {

		return weeklyUpdateService.getAllUpdates();
	}

	@GetMapping("/{id}")
	public WeeklyUpdate getUpdateById(@PathVariable Long id) {

		return weeklyUpdateService.getUpdateById(id);
	}

	@GetMapping("/user/{userId}")
	public List<WeeklyUpdate> getUserUpdates(@PathVariable Long userId) {

		return weeklyUpdateService.getUpdatesByUser(userId);
	}

	@GetMapping("/project/{projectId}")
	public List<WeeklyUpdate> getProjectUpdates(@PathVariable Long projectId) {

		return weeklyUpdateService.getUpdatesByProject(projectId);
	}

	@DeleteMapping("/{id}")
	public String deleteUpdate(@PathVariable Long id) {

		weeklyUpdateService.deleteUpdate(id);

		return "Weekly Update Deleted Successfully";
	}
}