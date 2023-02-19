package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Project;

import jakarta.transaction.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Modifying
	@Transactional
	@Query(value="UPDATE project p SET p.id_pm = :idPm WHERE p.id = :projectId", nativeQuery = true)
	void assignToPm(@Param("projectId") Long projectId , @Param("idPm") Long idPm);

}
