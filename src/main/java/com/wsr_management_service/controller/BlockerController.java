package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.Blocker;
import com.wsr_management_service.service.BlockerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/blockers")
@RequiredArgsConstructor
public class BlockerController {

	private final BlockerService blockerService;

	@PostMapping
	public Blocker createBlocker(@RequestBody Blocker blocker) {

		return blockerService.save(blocker);
	}

	@GetMapping
	public List<Blocker> getAllBlockers() {

		return blockerService.getAllBlockers();
	}

	@GetMapping("/{id}")
	public Blocker getBlockerById(@PathVariable Long id) {

		return blockerService.getBlockerById(id);
	}

	@GetMapping("/update/{updateId}")
	public List<Blocker> getBlockersByUpdate(@PathVariable Long updateId) {

		return blockerService.getBlockersByWeeklyUpdate(updateId);
	}

	@DeleteMapping("/{id}")
	public String deleteBlocker(@PathVariable Long id) {

		blockerService.deleteBlocker(id);

		return "Blocker deleted successfully";
	}
}