package com.ticketsystem.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.entity.Badge;
import com.ticketsystem.entity.TimeLog;
import com.ticketsystem.repository.AccessRecordRepository;
import com.ticketsystem.service.AccessRecordService;
import com.ticketsystem.service.BadgeService;
import com.ticketsystem.service.TimeLogService;

@Service
public class AccessRecordServiceImpl implements AccessRecordService{
	
	@Autowired
	private AccessRecordRepository accessRecordRepository;
	@Autowired
	private BadgeService badgeService;
	@Autowired
	private TimeLogService timeLogService;

	@Override
	public void saveEntryRecord(Long idEmployee) {
		Badge badge = badgeService.getBadgeByEmployeeId(idEmployee);
		timeLogService.save(new TimeLog(LocalDateTime.now(),"ENTRY",badge));	
	}

	@Override
	public void saveExitRectord(Long idEmployee) {
		Badge badge = badgeService.getBadgeByEmployeeId(idEmployee);
		timeLogService.save(new TimeLog(LocalDateTime.now(),"EXIT",badge));
		
	}
	
	
}
