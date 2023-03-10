package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.dto.ProjectAssignmentDto;
import com.ticketsystem.dto.ProjectDto;
import com.ticketsystem.entity.Project;
import com.ticketsystem.entity.ProjectAssignment;

public interface ProjectService {
	
	void assignProjectToPm(Long projectId, Long pmId);

	List<ProjectDto> getAllProject();

	void createProject(ProjectDto projectDto);

	Project finById(Long projectId);

	List<ProjectAssignmentDto> getAssignmentProjects(Long projectId);
	
	void saveProjectAssignment(ProjectAssignment projectAssignment);

}
