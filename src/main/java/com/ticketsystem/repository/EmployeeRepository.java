package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Role;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value="SELECT * FROM employee WHERE id = :id ", nativeQuery=true )
	Employee getEmployeeById(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO employee (nome, cognome, id_role) VALUES (:nome,:cognome,:roleId)",nativeQuery = true)
	void create(@Param("nome") String nome, @Param("cognome") String cognome, @Param("roleId") Long roleId);

	@Query(value="SELECT * FROM employee WHERE id_role = 1",nativeQuery = true)
	List<Employee> findAllByRolePm();

	@Query(value="SELECT * FROM employee WHERE id_role = 2",nativeQuery = true)
	List<Employee> findAllByRoleDevs();

}
