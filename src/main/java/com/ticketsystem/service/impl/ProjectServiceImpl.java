package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.dto.ProjectAssignmentDto;
import com.ticketsystem.dto.ProjectDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Project;
import com.ticketsystem.entity.ProjectAssignment;
import com.ticketsystem.repository.ProjectAssignmentRepository;
import com.ticketsystem.repository.ProjectRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.ProjectService;


@Service
public class ProjectServiceImpl  implements ProjectService {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectAssignmentRepository projectAssignmentRepository;

	@Override
	public void assignProjectToPm(Long projectId, Long pmId) {
		Employee employee = employeeService.findById(pmId);
		if(employee!=null) {
			projectRepository.assignToPm(projectId, pmId);
		}
		
	}

	@Override
	public List<ProjectDto> getAllProject() {
		List<Project> projects = projectRepository.getAll();
		return  projects.stream()
				.map(project->new ProjectDto(project.getId(),project.getName(),project.getPm().getId()))
				.collect(Collectors.toList());
		 
	}

	@Override
	public void createProject(ProjectDto projectDto) {
		System.out.println(projectDto.getName() + "" + projectDto.getPmdId());
		Employee employee = employeeService.findById(projectDto.getPmdId());
		projectRepository.saveProject(projectDto.getName(), employee.getId());
		
	}

	@Override
	public Project finById(Long projectId) {
		return projectRepository.findById(projectId).get();
	}
	@Override
	public List<ProjectAssignmentDto> getAssignmentProjects(Long projectId) {
		List<ProjectAssignment> projects = projectAssignmentRepository.getAssignmentProjects(projectId);
		return  projects.stream()
				.map(project->new ProjectAssignmentDto(project.getId(),project.getEmployee().getId(),
						project.getProject().getId(),project.getTeamName()))
				.collect(Collectors.toList());
	}

	@Override
	public void saveProjectAssignment(ProjectAssignment projectAssignment) {
		projectAssignmentRepository.save(projectAssignment);
		
	}
	

}
