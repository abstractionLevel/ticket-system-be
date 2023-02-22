package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.dto.EmployeeDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Role;
import com.ticketsystem.entity.Team;
import com.ticketsystem.repository.EmployeeRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.RoleService;
import com.ticketsystem.service.TeamService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleService roleService;
	@Autowired
	private TeamService teamService;
	@Override
	public Employee findById(Long id) {
		Employee employee =  employeeRepository.getEmployeeById(id);
		return employee;

	}
	
	@Override
	public void create(EmployeeDto employeeDto) {
		Role role =  roleService.getById(employeeDto.getRoleId());
		Team team =  teamService.getById(employeeDto.getTeamId());
		
		if(role!=null && team!=null) {
			Employee  employee = new Employee(employeeDto.getNome(),employeeDto.getCognome(),role,team);
			employeeRepository.create(employee.getNome(),employee.getCognome(),employee.getRole().getId(), employee.getTeam().getId(),employeeDto.getReferentId());
		}else {
		}
		
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee ->
			new EmployeeDto(employee.getNome(),employee.getCognome(),employee.getRole().getId(),employee.getId(),(long) 1,employee.getReferent())).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getPms() {
		List<Employee> employees = employeeRepository.findAllByRolePm();
		return employees.stream().map(employee ->
			new EmployeeDto(employee.getNome(),employee.getCognome(),employee.getRole().getId(),employee.getId())).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getDevs() {
		List<Employee> employees = employeeRepository.findAllByRoleDevs();
		return employees.stream().map(employee ->
			new EmployeeDto(employee.getNome(),employee.getCognome(),employee.getRole().getId(),employee.getId())).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getById(Long id) {
		Employee employee = employeeRepository.getById(id);
		return new EmployeeDto(employee.getNome(),employee.getCognome(),employee.getRole().getId(),employee.getId(),employee.getTeam().getNome());
	}

}
