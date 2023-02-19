package com.ticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsystem.service.AccessRecordService;

@RestController
@RequestMapping("api/access-records")
public class AccessRecordController {
	
	@Autowired
	private AccessRecordService accessRecordService;
	
	@PostMapping("/{idEmployee}/entry")
	public ResponseEntity<Void> saveEntryRecord(@PathVariable Long idEmployee) {
		try {
			accessRecordService.saveEntryRecord(idEmployee);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

}
