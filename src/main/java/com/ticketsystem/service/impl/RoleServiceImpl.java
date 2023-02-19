package com.ticketsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketsystem.entity.Role;
import com.ticketsystem.repository.RoleRepository;
import com.ticketsystem.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getList() {
		return roleRepository.getAllRole();
	}

}
