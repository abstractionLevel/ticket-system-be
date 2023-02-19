package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.TaskDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Task;
import com.ticketsystem.repository.TaskAssignmentRepository;
import com.ticketsystem.repository.TaskRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskAssignmentRepository taskAssignmentRepository;
	
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

	@Override
	public List<TaskDto> getAllTaskByProjectId(Long projectId) {
		List<Task> tasks = taskRepository.findAllTaskByProjectId(projectId);
		List<TaskDto> taskDTOs = tasks.stream()
                .map(task -> new TaskDto( task.getDescrizione(),task.getDeadline(),task.getStatus(),task.getPm().getId())).collect(Collectors.toList());
		return  taskDTOs;
	}

	@Override
	public void assignTaskToDeveloper(Long taskId, Long devId) {
		Task task  = taskRepository.getById(taskId);
		Employee employee = employeeService.findById(devId);
		if(task!=null && employee!=null) {
			taskAssignmentRepository.save(task.getId(),employee.getId());
		}
		
	}

	@Override
	public Task getById(Long id) {
		return taskRepository.getById(id);
	}

}
