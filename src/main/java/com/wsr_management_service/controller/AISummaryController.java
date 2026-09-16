package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.AISummary;
import com.wsr_management_service.service.AISummaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ai-summaries")
@RequiredArgsConstructor
public class AISummaryController {

	private final AISummaryService aiSummaryService;

	@PostMapping
	public AISummary createSummary(@RequestBody AISummary aiSummary) {

		return aiSummaryService.save(aiSummary);
	}

	@GetMapping
	public List<AISummary> getAllSummaries() {

		return aiSummaryService.getAllSummaries();
	}

	@GetMapping("/{id}")
	public AISummary getSummaryById(@PathVariable Long id) {

		return aiSummaryService.getSummaryById(id);
	}

	@GetMapping("/update/{updateId}")
	public AISummary getSummaryByUpdate(@PathVariable Long updateId) {

		return aiSummaryService.getSummaryByUpdateId(updateId);
	}

	@DeleteMapping("/{id}")
	public String deleteSummary(@PathVariable Long id) {

		aiSummaryService.deleteSummary(id);

		return "AI Summary deleted successfully";
	}
}