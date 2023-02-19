package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Long>{
	
	
	@Query(value="SELECT * FROM badge WHERE id_employee = :idEmployee", nativeQuery = true)
	Badge getBadgeByEmployeeId(@Param("idEmployee") Long idEmployee);

}
