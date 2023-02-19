package com.ticketsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Task;

import jakarta.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO task (deadline,descrizione,status,id_pm,id_project) VALUES (:deadLine,:description,:status,:pmId,:projectId)",nativeQuery = true)
	void save(@Param("deadLine") LocalDate deadLine, @Param("description") String description , @Param("status") String status,@Param("pmId") Long pmId , @Param("projectId") Long projectId );

	@Query(value="SELECT * FROM task WHERE id_project = :projectId", nativeQuery = true)
	List<Task> findAllTaskByProjectId(@Param("projectId") Long projectId);
	
	@Query(value="SELECT * FROM task WHERE id=:taskId",nativeQuery = true) 
	Task getById(@Param("taskId") Long taskId);
}