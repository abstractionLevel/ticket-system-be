package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.TaskDto;
import com.ticketsystem.dto.TaskAssignmentDto;
import com.ticketsystem.entity.Task;

public interface TaskService {
	
	void createTask(Long projectId, TaskDto taskDto);

	List<TaskDto> getAllTaskByProjectId(Long projectId);

	void assignTaskToDeveloper(Long taskId, Long devId);
	
	Task getById(Long id);

	List<TaskAssignmentDto> getAssignedTasks(Long taskId);

	void deleteAssignedTask(Long taskId);

	List<TaskDto> getTasksByStatus(String status, Long id);
}
