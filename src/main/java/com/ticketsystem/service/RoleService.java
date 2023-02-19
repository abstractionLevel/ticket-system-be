package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.entity.Role;

public interface RoleService {

	List<Role> getList();
	Role getById(Long id);
}
