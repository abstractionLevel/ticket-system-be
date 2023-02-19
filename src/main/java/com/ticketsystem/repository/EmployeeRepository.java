package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value="SELECT * FROM employee WHERE id = :id ", nativeQuery=true )
	Employee getById(@Param("id") Long id);

}
