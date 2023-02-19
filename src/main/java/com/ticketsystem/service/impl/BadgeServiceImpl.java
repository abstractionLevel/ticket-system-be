package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.entity.Badge;
import com.ticketsystem.repository.BadgeRepository;
import com.ticketsystem.service.BadgeService;

@Service
public class BadgeServiceImpl implements BadgeService{
	
	@Autowired
	private BadgeRepository badgeRepository;

	@Override
	public Badge getBadgeByEmployeeId(Long id) {
		return badgeRepository.getBadgeByEmployeeId(id);
	}
	
	

}
