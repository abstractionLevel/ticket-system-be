package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.dto.ProjectDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Project;
import com.ticketsystem.repository.ProjectRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.ProjectService;


@Service
public class ProjectServiceImpl  implements ProjectService {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectRepository projectRepository;

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

}
