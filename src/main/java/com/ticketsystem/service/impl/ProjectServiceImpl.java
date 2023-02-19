package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.entity.Employee;
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

}
