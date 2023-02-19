package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value="SELECT * FROM employee WHERE id = :devId ", nativeQuery=true )
	Employee getById(@Param("devId") Long devId);
	
	@Modifying
	@Transactional
	@Query(value="INSER INTO (nome, cognome, id_role) VALUES (nome,cognome,roleId")
	void save(@Param("nome") String nome, @Param("cognome") String cognome, @Param("roleId") Long roleId);

}
