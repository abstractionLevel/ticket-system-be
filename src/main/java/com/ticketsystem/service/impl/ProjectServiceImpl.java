package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketsystem.repository.EmployeeRepository;
import com.ticketsystem.service.ProjectService;

public class ProjectServiceImpl  implements ProjectService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void assignProjectToPm(Long projectId, Long pmId) {
		// TODO Auto-generated method stub
		
	}

}
