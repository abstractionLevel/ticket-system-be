package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Project;

import jakarta.transaction.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Modifying
	@Transactional
	@Query(value="UPDATE project p SET p.id_pm = :pmId WHERE p.id = :projectId", nativeQuery = true)
	void assignToPm(@Param("projectId") Long projectId , @Param("pmId") Long pmId);

	@Query(value="SELECT * FROM project",  nativeQuery = true)
	List<Project> getAll();

	@Modifying
	@Transactional
	@Query(value="INSERT INTO project (name, id_pm) VALUES (:name,:pmId) ", nativeQuery = true)
	void saveProject(@Param("name") String name , @Param("pmId") Long pmId);

}
