package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketsystem.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
