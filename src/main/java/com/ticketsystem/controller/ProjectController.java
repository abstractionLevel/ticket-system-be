package com.ticketsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.entity.Project;

@RestController
@RequestMapping("api/project")
public class ProjectController {
	
	@PostMapping("/pm/{pmId}/assign-project")
	public ResponseEntity<Project> assignProject(@PathVariable Long pmId, @RequestParam Long projectId) {
		try {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
