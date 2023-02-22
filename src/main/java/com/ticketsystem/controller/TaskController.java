	package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.TaskDto;
import com.ticketsystem.dto.NoteDto;
import com.ticketsystem.dto.TaskAssignmentDto;
import com.ticketsystem.entity.ProjectAssignment;
import com.ticketsystem.service.NoteService;
import com.ticketsystem.service.ProjectAssignmentService;
import com.ticketsystem.service.TaskService;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private NoteService noteService;
	@Autowired
	private ProjectAssignmentService projectAssignmentTaskService;
	

	@GetMapping("{status}/projects/{id}")
	public ResponseEntity<List<TaskDto>> getTasksByStatus(@PathVariable String status,@PathVariable Long id ) {
		try {
			List<TaskDto> taskDtos = taskService.getTasksByStatus(status,id);
			return new ResponseEntity<>(taskDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("{taskId}/assigned-developer")
	public ResponseEntity<List<TaskAssignmentDto>> getAssigneTasks(@PathVariable Long taskId ) {
		try {
			List<TaskAssignmentDto> taskDtos = taskService.getAssignedTasks(taskId);
			return new ResponseEntity<>(taskDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("{taskId}/assigned-developer/{id}")
	public ResponseEntity<?> deleteAssignedTask(@PathVariable Long taskId  , @PathVariable Long id) {
		try {
			taskService.deleteAssignedTask(id);
			projectAssignmentTaskService.delete(id, taskId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{taskId}/assigned-developer")
	public ResponseEntity<?> assignTaskToDeveloper(@PathVariable Long taskId, @RequestParam Long developerId ) {
		try {
			taskService.assignTaskToDeveloper(taskId,developerId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	@PostMapping("{taskId}/notes")
	public ResponseEntity<?> createNote(@PathVariable Long taskId,@RequestBody NoteDto noteDto) {
		try {
			noteService.create(noteDto, taskId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("{taskId}/notes")
	public ResponseEntity<List<NoteDto>> getAllNotes(@PathVariable Long taskId) {
		try {
			
			List<NoteDto> noteDto =  noteService.getNotesByTaskId(taskId);
			return new ResponseEntity<>(noteDto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
