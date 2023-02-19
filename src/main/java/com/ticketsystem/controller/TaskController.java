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

import com.ticketsystem.dto.NoteDto;
import com.ticketsystem.service.NoteService;
import com.ticketsystem.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private NoteService noteService;
	
	
	@PostMapping("/{taskId}/assigned-developer")
	public ResponseEntity<?> assignTaskToDeveloper(@PathVariable Long taskId, @RequestParam Long developerId ) {
		try {
			taskService.assignTaskToDeveloper(taskId,developerId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("{taskId}/note")
	public ResponseEntity<?> createNote(@PathVariable Long taskId,@RequestBody NoteDto noteDto) {
		try {
			noteService.create(noteDto, taskId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
