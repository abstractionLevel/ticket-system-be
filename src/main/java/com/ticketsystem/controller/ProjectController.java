package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.TaskDto;
import com.ticketsystem.dto.ProjectAssignmentDto;
import com.ticketsystem.dto.ProjectDto;
import com.ticketsystem.entity.Project;
import com.ticketsystem.entity.Task;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.ProjectService;
import com.ticketsystem.service.TaskService;

@RestController
@RequestMapping("api/projects")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) {
		try {
			projectService.createProject(projectDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{projectId}/assign")
	public ResponseEntity<Project> assignProject(@PathVariable Long projectId, @RequestParam Long pmId) {
		try {
			projectService.assignProjectToPm(projectId, pmId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<ProjectDto>> getProject() {
		try {
			List<ProjectDto> projectDtos = projectService.getAllProject();
			return new ResponseEntity<>(projectDtos, HttpStatus.CREATED);
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
	
	@GetMapping("/{projectId}/tasks")
	public ResponseEntity<List<TaskDto>> getTasks(@PathVariable Long projectId) {
		try {
			List<TaskDto> tasksdDtos = taskService.getAllTaskByProjectId(projectId);
			return  new ResponseEntity<>(tasksdDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
	
	@GetMapping("/{projectId}/teams")
	public ResponseEntity<List<ProjectAssignmentDto>> hasDifferentTeams(@PathVariable Long projectId) {
		try {
			List<ProjectAssignmentDto> dtos = projectService.getAssignmentProjects(projectId);
			return  new ResponseEntity<>(dtos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
