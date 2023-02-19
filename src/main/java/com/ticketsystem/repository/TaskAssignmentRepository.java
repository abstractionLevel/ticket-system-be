package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.TaskAssignment;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long>{
	
	@Query(value = "INSERT INTO task_assignment (developer_id, task_id) VALUES (:devId,:taskId)", nativeQuery = true)
	void save(@Param("taskId") Long taskId, @Param("devId") Long devId);

}
