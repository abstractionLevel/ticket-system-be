package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.dto.TeamDto;
import com.ticketsystem.service.TeamService;

@RestController
@RequestMapping("api/teams")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TeamConstrolller {

	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public ResponseEntity<List<TeamDto>> getPms() {
		try {
			List<TeamDto> teamDtos = teamService.getAllTeam();
			return  new ResponseEntity<>(teamDtos,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	}
}
