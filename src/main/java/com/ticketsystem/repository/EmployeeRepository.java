package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	

}
