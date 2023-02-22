package com.ticketsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.dto.NoteDto;
import com.ticketsystem.entity.Employee;
import com.ticketsystem.entity.Note;
import com.ticketsystem.entity.Task;
import com.ticketsystem.repository.NoteRepository;
import com.ticketsystem.service.EmployeeService;
import com.ticketsystem.service.NoteService;
import com.ticketsystem.service.TaskService;


@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TaskService taskService;
	
	@Override
	public void create(NoteDto noteDto,Long taskId) {
		Task task =  taskService.getById(taskId);
		Employee employee =  employeeService.findById(noteDto.getDeveloperId());
		if(task!=null && employee!=null) {
			Note note = new Note(noteDto.getDescrizione(),task,employee);
			noteRepository.save(note);
		}
		else {
		}
	}

	@Override
	public List<NoteDto> getNotesByTaskId(Long taskId) {
		List<Object[]> results =   noteRepository.getNoteByTaskId(taskId);
		List<NoteDto> noteDtos = new ArrayList<>();
		for (Object[] result : results) {
            String descrizione = (String) result[0];
            String nome = (String) result[1];
            String cognome = (String) result[2];
            NoteDto noteDto = new NoteDto(descrizione, nome, cognome);
            noteDtos.add(noteDto);
        }

        return noteDtos;
	}

}
