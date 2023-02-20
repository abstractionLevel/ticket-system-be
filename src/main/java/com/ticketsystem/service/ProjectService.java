package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.dto.ProjectDto;
import com.ticketsystem.entity.Project;

public interface ProjectService {
	
	void assignProjectToPm(Long projectId, Long pmId);

	List<ProjectDto> getAllProject();

	void createProject(ProjectDto projectDto);

	Project finById(Long projectId);

}
