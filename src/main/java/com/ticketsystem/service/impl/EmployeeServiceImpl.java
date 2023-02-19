package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.dto.EmployeeDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Role;
import com.ticketsystem.repository.EmployeeRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.RoleService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleService roleService;
	
	@Override
	public Employee findById(Long id) {
		return  employeeRepository.getById(id);

	}

	@Override
	public void create(EmployeeDto employeeDto) {
		Role role =  roleService.getById(employeeDto.getRoleId());
		if(role!=null) {
			Employee  employee = new Employee(employeeDto.getNome(),employeeDto.getCognome(),role);
			employeeRepository.create(employee.getNome(),employee.getCognome(),employee.getRole().getId());
		}else {
		}
		
	}

}
