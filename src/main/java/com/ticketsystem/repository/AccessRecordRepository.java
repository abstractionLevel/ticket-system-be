package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketsystem.entity.TimeLog;

public interface AccessRecordRepository extends JpaRepository<TimeLog, Long>{

}
