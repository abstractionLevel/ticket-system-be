package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketsystem.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value="SELECT * FROM role")
	List<Role> getAllRole();

}
