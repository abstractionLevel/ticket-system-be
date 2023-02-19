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
	public void createTask(Long idProject, Task task) {
		// TODO Auto-generated method stub
		
	}

}
