package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.ProjectAssignment;

import jakarta.transaction.Transactional;

public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment,Long>{
	
	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM project_assignment WHERE project_id = :projecId", nativeQuery = true)
	List<ProjectAssignment> getAssignmentProjects(@Param("projecId") Long projecId); 

}
