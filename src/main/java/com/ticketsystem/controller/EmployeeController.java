package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.dto.EmployeeDto;
import com.ticketsystem.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		try {
			EmployeeDto employeeDto = employeeService.getById(id);
			return  new ResponseEntity<>(employeeDto,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployees() {
		try {
			List<EmployeeDto> employeeDtos = employeeService.getEmployees();
			return  new ResponseEntity<>(employeeDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
	
	@GetMapping("/role/pms")
	public ResponseEntity<List<EmployeeDto>> getPms() {
		try {
			List<EmployeeDto> employeeDtos = employeeService.getPms();
			return  new ResponseEntity<>(employeeDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
	
	@GetMapping("/role/devs")
	public ResponseEntity<List<EmployeeDto>> getDevs() {
		try {
			List<EmployeeDto> employeeDtos = employeeService.getDevs();
			return  new ResponseEntity<>(employeeDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
 

}
