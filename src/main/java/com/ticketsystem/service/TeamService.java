package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.dto.TeamDto;
import com.ticketsystem.entity.Team;

public interface TeamService {
	
	List<TeamDto> getAllTeam();

	Team getById(Long teamId);

}
