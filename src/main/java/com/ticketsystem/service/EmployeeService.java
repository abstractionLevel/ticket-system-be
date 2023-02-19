package com.ticketsystem.service;

import com.ticketsystem.dto.EmployeeDto;
import com.ticketsystem.entity.Employee;

public interface EmployeeService {
	
	Employee findById(Long id);
	void create(EmployeeDto employeeDto);
}
