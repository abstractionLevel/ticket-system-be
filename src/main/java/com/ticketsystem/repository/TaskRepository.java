package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	
	@Query(value="SELECT * FROM task WHERE id_project = :projectId", nativeQuery = true)
	List<Task> findAllTaskByProjectId(@Param("projectId") Long projectId);
	
	@Query(value="SELECT * FROM task WHERE id=:taskId",nativeQuery = true) 
	Task getById(@Param("taskId") Long taskId);

	@Query(value="SELECT * FROM task WHERE status = :status", nativeQuery = true)
	List<Task> findAllTasksByStatus(@Param("status") String status);
}