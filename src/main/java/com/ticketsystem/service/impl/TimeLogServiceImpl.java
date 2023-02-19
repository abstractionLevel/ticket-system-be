package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.entity.TimeLog;
import com.ticketsystem.repository.TimeLogRepository;
import com.ticketsystem.service.TimeLogService;

@Service
public class TimeLogServiceImpl implements TimeLogService{

	@Autowired
	private TimeLogRepository timeLogRepository;
	
	@Override
	public void save(TimeLog timeLog) {
		timeLogRepository.save(timeLog.getAccessTime(), timeLog.getAccessType(),timeLog.getBadge().getId());
	}

}
