package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.TaskAssignment;

import jakarta.transaction.Transactional;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO task_assignment (developer_id, task_id) VALUES (:devId,:taskId)", nativeQuery = true)
	void save(@Param("taskId") Long taskId, @Param("devId") Long devId);

	@Query(value = "SELECT * FROM task_assignment WHERE task_id = :taskId", nativeQuery = true)
	List<TaskAssignment> getAllAssignmentTasks(Long taskId);

	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM task_assignment   WHERE developer_id = :devId", nativeQuery = true)
	void deleteAssigned(@Param("devId") Long devId);

}
