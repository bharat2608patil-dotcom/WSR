package com.wsr_management_service.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.entity.Project;
import com.wsr_management_service.service.ProjectService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService projectService;

	@PostMapping
	public Project createProject(@RequestBody Project project) {

		return projectService.save(project);
	}

	@GetMapping
	public List<Project> getAllProjects() {

		return projectService.getAllProjects();
	}

	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable Long id) {

		return projectService.getProjectById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteProject(@PathVariable Long id) {

		projectService.deleteProject(id);

		return "Project deleted successfully";
	}
}