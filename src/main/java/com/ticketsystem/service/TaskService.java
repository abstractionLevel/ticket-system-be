package com.ticketsystem.service;

import com.ticketsystem.entity.Task;

public interface TaskService {
	
	void createTask(Long projectId, Task task);
}
