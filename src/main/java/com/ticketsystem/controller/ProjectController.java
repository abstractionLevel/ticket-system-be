package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.TaskDto;
import com.ticketsystem.entity.Project;
import com.ticketsystem.entity.Task;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.ProjectService;
import com.ticketsystem.service.TaskService;

@RestController
@RequestMapping("api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/{projectId}/assign")
	public ResponseEntity<Project> assignProject(@PathVariable Long projectId, @RequestParam Long pmId) {
		try {
			projectService.assignProjectToPm(projectId, pmId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("{projectId}/tasks")
	public ResponseEntity<Task> createTaskForProject(@PathVariable Long projectId, @RequestBody TaskDto taskDto) {
		try {
			taskService.createTask(projectId, taskDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	
	}
	
	@GetMapping("{projectId}/tasks")
	public ResponseEntity<List<Task>> getTasks(@PathVariable Long projectId) {
		try {
			List<Task> tasks = taskService.getAllTaskByProjectId(projectId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}

}
