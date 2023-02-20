package com.ticketsystem.dto;

public class ProjectDto {
	
	private String name;
	private Long pmdId; 
	private Long id;
	
	public ProjectDto(Long id, String name, Long pmId) {
		this.id = id;
		this.pmdId = pmId;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPmdId() {
		return pmdId;
	}
	public void setPmdId(Long pmdId) {
		this.pmdId = pmdId;
	}
	
	
}
