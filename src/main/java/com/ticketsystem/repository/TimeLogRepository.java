package com.ticketsystem.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.TimeLog;

import jakarta.transaction.Transactional;

public interface TimeLogRepository extends JpaRepository<TimeLog, Long> {

	@Modifying
	@Transactional
	@Query(value="INSERT INTO time_log (access_time, access_type,id_badge) VALUES (:accessTime,:access_type,:idBadge)", nativeQuery=true)
	void save(@Param("accessTime") LocalDateTime accessTime, @Param("access_type") String accesssType,@Param("idBadge") Long idBadge);
}
