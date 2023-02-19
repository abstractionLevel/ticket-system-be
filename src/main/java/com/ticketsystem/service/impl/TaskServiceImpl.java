package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.TaskDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Task;
import com.ticketsystem.repository.TaskRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void createTask(Long projectId, TaskDto taskDto) {	
		Employee employee = employeeService.findById(taskDto.getPmId());
		if(employee!=null) {
			Task task =  new Task();
			task.setDeadline(taskDto.getDeadline());
			task.setDescrizione(taskDto.getDescrizione());
			task.setStatus(taskDto.getStatus());
			task.setPm(employee);
			taskRepository.save(task.getDeadline(),task.getDescrizione(), task.getStatus(),task.getPm().getId(),projectId);
		}
		
		
	}

}
