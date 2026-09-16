package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.Team;

public interface TeamService {

	Team save(Team team);

	List<Team> getAllTeams();

	Team getTeamById(Long id);

	void deleteTeam(Long id);
}