package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketsystem.dto.NoteDto;
import com.ticketsystem.service.NoteService;

public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public void create(NoteDto noteDto) {
		
		
	}

}
