package com.ticketsystem.service;

import com.ticketsystem.TaskDto;

public interface TaskService {
	
	void createTask(Long projectId, TaskDto taskDto);
}
