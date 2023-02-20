package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
		Employee employee =  employeeRepository.getEmployeeById(id);
		return employee;

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

	@Override
	public List<EmployeeDto> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee ->
			new EmployeeDto(employee.getNome(),employee.getCognome(),employee.getRole().getId(),employee.getId())).collect(Collectors.toList());
	}

}
