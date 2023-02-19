package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketsystem.entity.Team;

public interface TeamRepository extends JpaRepository<Team,Long>{

}
