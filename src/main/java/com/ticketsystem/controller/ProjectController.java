package com.ticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.entity.Project;
import com.ticketsystem.entity.Task;
import com.ticketsystem.service.ProjectService;

@RestController
@RequestMapping("api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/{projectId}/assign")
	public ResponseEntity<Project> assignProject(@PathVariable Long projectId, @RequestParam Long pmId) {
		try {
			projectService.assignProjectToPm(projectId, pmId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> createTaskForProject(@PathVariable Long projectId, @RequestBody Task task) {
		try {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}

}
