package com.ticketsystem.dto;

public class TaskAssignmentDto {
	
	private Long id;
	private Long devId;
	private Long taskId;
	
	
	public TaskAssignmentDto(Long id, Long devId, Long taskId) {
		super();
		this.id = id;
		this.devId = devId;
		this.taskId = taskId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDevId() {
		return devId;
	}
	public void setDevId(Long devId) {
		this.devId = devId;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	
	

}
