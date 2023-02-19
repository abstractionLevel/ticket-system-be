package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.entity.Task;
import com.ticketsystem.repository.TaskRepository;
import com.ticketsystem.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void createTask(Long projectId, Task task) {		
		taskRepository.save(task.getDeadline(),task.getDescrizione(), task.getStatus(),projectId);
		
	}

}
