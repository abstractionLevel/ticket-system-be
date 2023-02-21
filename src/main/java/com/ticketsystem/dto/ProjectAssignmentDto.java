package com.ticketsystem.dto;

public class ProjectAssignmentDto  {
	
	
    private Long id;
	
	private Long employeeId;

	private Long projectId;
	
	private String teamName;
	

	public ProjectAssignmentDto(Long id, Long employeeId, Long projectId, String teamName) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.teamName = teamName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	} 

}
