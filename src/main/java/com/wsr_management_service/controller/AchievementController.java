package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.Achievement;
import com.wsr_management_service.service.AchievementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/achievements")
@RequiredArgsConstructor
public class AchievementController {

	private final AchievementService achievementService;

	@PostMapping
	public Achievement createAchievement(@RequestBody Achievement achievement) {

		return achievementService.save(achievement);
	}

	@GetMapping
	public List<Achievement> getAllAchievements() {

		return achievementService.getAllAchievements();
	}

	@GetMapping("/{id}")
	public Achievement getAchievementById(@PathVariable Long id) {

		return achievementService.getAchievementById(id);
	}

	@GetMapping("/update/{updateId}")
	public List<Achievement> getByUpdate(@PathVariable Long updateId) {

		return achievementService.getAchievementsByWeeklyUpdate(updateId);
	}

	@DeleteMapping("/{id}")
	public String deleteAchievement(@PathVariable Long id) {

		achievementService.deleteAchievement(id);

		return "Achievement deleted successfully";
	}
}