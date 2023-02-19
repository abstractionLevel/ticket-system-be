package com.ticketsystem.service;

import com.ticketsystem.dto.NoteDto;

public interface NoteService {

	void create(NoteDto noteDto,Long TaskId);
}
