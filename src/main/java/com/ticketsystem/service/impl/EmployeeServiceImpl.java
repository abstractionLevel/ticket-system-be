package com.ticketsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void create(Employee employee) {
		List<Role> roles = roleService.getList();
	}

}
