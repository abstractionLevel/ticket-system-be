package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketsystem.entity.Employee;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.ProjectService;

public class ProjectServiceImpl  implements ProjectService {
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public void assignProjectToPm(Long projectId, Long pmId) {
		Employee employee = employeeService.findById(pmId);
		if(employee!=null) {
			System.out.print("Employee " + employee);
		}
		
	}

}
