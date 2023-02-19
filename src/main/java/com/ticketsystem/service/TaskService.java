package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.TaskDto;
import com.ticketsystem.entity.Task;

public interface TaskService {
	
	void createTask(Long projectId, TaskDto taskDto);

	List<Task> getAllTaskByProjectId(Long projectId);
}
