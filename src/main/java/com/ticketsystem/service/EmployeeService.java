package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.dto.EmployeeDto;
import com.ticketsystem.entity.Employee;

public interface EmployeeService {
	
	Employee findById(Long id);
	
	void create(EmployeeDto employeeDto);
	
	List<EmployeeDto> getEmployees();

	List<EmployeeDto> getPms();

	List<EmployeeDto> getDevs();

	EmployeeDto getById(Long id);
}
