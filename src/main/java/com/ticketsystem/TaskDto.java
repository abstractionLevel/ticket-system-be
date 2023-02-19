package com.ticketsystem;

import java.time.LocalDate;

import com.ticketsystem.entity.Employee;

public class TaskDto {

	private String descrizione;
	private LocalDate deadline;
	private Long pmId;
	private String status;
	
	public TaskDto( String descrizione) {
		this.descrizione = descrizione;
	}
	public TaskDto(String descrizione, LocalDate deadline, String status,  Long pmId) {
		this.descrizione = descrizione;
		this.deadline = deadline;
		this.status = status;
		this.pmId = pmId;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public Long getPmId() {
		return pmId;
	}
	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

