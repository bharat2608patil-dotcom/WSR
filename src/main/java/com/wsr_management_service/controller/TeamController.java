package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.Team;
import com.wsr_management_service.service.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

	private final TeamService teamService;

	@PostMapping
	public Team createTeam(@RequestBody Team team) {

		return teamService.save(team);
	}

	@GetMapping
	public List<Team> getAllTeams() {

		return teamService.getAllTeams();
	}

	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable Long id) {

		return teamService.getTeamById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteTeam(@PathVariable Long id) {

		teamService.deleteTeam(id);

		return "Team deleted successfully";
	}
}