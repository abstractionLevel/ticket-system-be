package com.ticketsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.repository.ProjectAssignmentRepository;
import com.ticketsystem.service.ProjectAssignmentService;

@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService {

	@Autowired
	private ProjectAssignmentRepository projectAssignmentRepository;
	@Override
	public void delete(Long devId, Long projectId) {
		projectAssignmentRepository.deleteByDevIdAndProjectId(devId,projectId);	
	}

}
