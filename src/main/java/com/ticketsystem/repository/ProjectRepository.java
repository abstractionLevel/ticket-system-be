package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Query(value="UPDATE project  p SET p.id_pm :idPm WHERE p.id = :projectId", nativeQuery = true)
	void assignToPm(@Param("projectId") Long projectId , @Param("idPm") Long idPm);

}
