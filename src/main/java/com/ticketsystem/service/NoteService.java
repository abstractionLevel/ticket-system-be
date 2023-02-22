package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.dto.NoteDto;

public interface NoteService {

	void create(NoteDto noteDto,Long TaskId);

	List<NoteDto> getNotesByTaskId(Long taskId);
}
