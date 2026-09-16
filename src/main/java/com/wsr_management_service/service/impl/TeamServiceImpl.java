package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.Team;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.TeamRepository;
import com.wsr_management_service.service.TeamService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;

	@Override
	public Team save(Team team) {

		log.info("Creating Team {}", team.getTeamName());

		return teamRepository.save(team);
	}

	@Override
	public List<Team> getAllTeams() {

		return teamRepository.findAll();
	}

	@Override
	public Team getTeamById(Long id) {

		return teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found with id " + id));
	}

	@Override
	public void deleteTeam(Long id) {

		Team team = getTeamById(id);

		teamRepository.delete(team);
	}
}