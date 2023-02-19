package com.ticketsystem.service;

import com.ticketsystem.entity.Task;

public interface TaskService {
	
	void createTask(Long idProject, Task task);
}
