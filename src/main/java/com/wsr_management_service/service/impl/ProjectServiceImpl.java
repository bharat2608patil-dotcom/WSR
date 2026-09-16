package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.Project;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.repository.ProjectRepository;
import com.wsr_management_service.service.ProjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;

	@Override
	public Project save(Project project) {

		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAllProjects() {

		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {

		return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
	}

	@Override
	public void deleteProject(Long id) {

		projectRepository.deleteById(id);
	}
}