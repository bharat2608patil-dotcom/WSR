package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.Project;

public interface ProjectService {

	Project save(Project project);

	List<Project> getAllProjects();

	Project getProjectById(Long id);

	void deleteProject(Long id);
}