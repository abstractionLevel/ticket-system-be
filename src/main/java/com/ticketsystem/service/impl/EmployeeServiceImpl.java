package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketsystem.entity.Employee;
import com.ticketsystem.repository.EmployeeRepository;
import com.ticketsystem.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee findById(Long id) {
		return  employeeRepository.getById(id);

	}

}
