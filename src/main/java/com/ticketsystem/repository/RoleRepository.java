package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketsystem.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
