package com.ticketsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.dto.TeamDto;
import com.ticketsystem.entity.Team;
import com.ticketsystem.repository.TeamRepository;
import com.ticketsystem.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public List<TeamDto> getAllTeam() {
		List<Team> teams = teamRepository.findAll();
		return teams.stream().map(team-> new TeamDto(team.getId(),team.getNome())).collect(Collectors.toList());
	}

}
