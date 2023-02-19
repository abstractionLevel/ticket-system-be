package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketsystem.dto.NoteDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Note;
import com.ticketsystem.entity.Task;
import com.ticketsystem.repository.NoteRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.NoteService;
import com.ticketsystem.service.TaskService;

public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskService taskService;
	
	@Override
	public void create(NoteDto noteDto) {
		Task task =  taskService.getById(noteDto.getTaskId());
		Employee employee =  employeeService.findById(noteDto.getDeveloperId());
		if(task!=null && employee!=null) {
			Note note = new Note(noteDto.getDescription(),task,employee);
			noteRepository.save(note);
		}
	}

}
