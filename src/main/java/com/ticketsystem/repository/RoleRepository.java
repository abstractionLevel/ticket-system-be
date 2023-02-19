package com.ticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value="SELECT * FROM roles",nativeQuery = true)
	List<Role> getAllRole();
	
	@Query(value="SELECT * FROM roles WHERE id=:id", nativeQuery = true)
	Role getById(@Param("id") Long id);

}
