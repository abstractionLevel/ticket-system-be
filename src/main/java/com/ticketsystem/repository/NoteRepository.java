package com.ticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketsystem.entity.Note;

import jakarta.transaction.Transactional;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
	@Modifying
	@Transactional
	@Query(value="INSER INTO note (descrizione, id_dev, id_task) VALUES(:description, :devId, :taskid)", nativeQuery = true)
	void save(@Param("description") String description, @Param("taskid") Long taskId, @Param("devId") Long devId);

}
