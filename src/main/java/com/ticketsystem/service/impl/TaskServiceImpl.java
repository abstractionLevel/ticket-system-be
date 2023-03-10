package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.TaskDto;
import com.ticketsystem.dto.TaskAssignmentDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Project;
import com.ticketsystem.entity.ProjectAssignment;
import com.ticketsystem.entity.Task;
import com.ticketsystem.entity.TaskAssignment;
import com.ticketsystem.repository.TaskAssignmentRepository;
import com.ticketsystem.repository.TaskRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.ProjectService;
import com.ticketsystem.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskAssignmentRepository taskAssignmentRepository;
	@Autowired
	private ProjectService projectService;
	
	@Override
	public void createTask(Long projectId, TaskDto taskDto) {	
		Employee employee = employeeService.findById(taskDto.getPmId());
		Project project = projectService.finById(projectId);
		if(employee!=null && project!=null) {
			Task task =  new Task();
			task.setDeadline(taskDto.getDeadline());
			task.setDescrizione(taskDto.getDescrizione());
			task.setStatus(taskDto.getStatus());
			task.setPm(employee);
			task.setProject(project);
			taskRepository.save(task);
			taskRepository.flush();
			this.assignTaskToDeveloper(task.getId(), employee.getId());
			ProjectAssignment projectAssignment = new ProjectAssignment(employee,project,employee.getTeam().getNome());
			projectService.saveProjectAssignment(projectAssignment);
		}else {
			System.out.println("problema con " + employee);
		}
	}

	@Override
	public List<TaskDto> getAllTaskByProjectId(Long projectId) {
		List<Task> tasks = taskRepository.findAllTaskByProjectId(projectId);
		List<TaskDto> taskDTOs = tasks.stream()
                .map(task -> new TaskDto(task.getId(), task.getDescrizione(),task.getDeadline(),task.getStatus(),task.getPm().getId())).collect(Collectors.toList());
		return  taskDTOs;
	}

	@Override
	public void assignTaskToDeveloper(Long taskId, Long devId) {
		Task task  = taskRepository.getById(taskId);
		Project project = projectService.finById(task.getProject().getId());
		Employee employee = employeeService.findById(devId);
		if(task!=null && employee!=null) {
			taskAssignmentRepository.save(task.getId(),employee.getId());
			ProjectAssignment projectAssignment = new ProjectAssignment(employee,project,employee.getTeam().getNome());
			projectService.saveProjectAssignment(projectAssignment);
		}
		
	}

	@Override
	public Task getById(Long id) {
		return taskRepository.getById(id);
	}

	@Override
	public List<TaskAssignmentDto> getAssignedTasks(Long taskId) {
		System.out.print("taskt id " + taskId);
		List<TaskAssignment> taskAssignments = taskAssignmentRepository.getAllAssignmentTasks(taskId);
		return taskAssignments.stream()
				.map(task -> new TaskAssignmentDto(task.getId(), task.getEmployee().getId(), task.getTask().getId())).collect(Collectors.toList());
	}

	@Override
	public void deleteAssignedTask(Long id) {
		taskAssignmentRepository.deleteAssigned(id);
	}

	@Override
	public List<TaskDto> getTasksByStatus(String status, Long id) {
		List<Task> tasks = taskRepository.findAllTasksByStatus(status,id);
		return tasks.stream()
                .map(task -> new TaskDto(task.getId(), task.getDescrizione(),task.getDeadline(),task.getStatus(),task.getPm().getId())).collect(Collectors.toList());
	}

}
