package com.ticketsystem.dto;

public class EmployeeDto {
	
	private String nome;
	private String cognome;
	private Long roleId;
	private Long id;
	private Long teamId;
	
	public EmployeeDto() {}
	
	public EmployeeDto(String nome, String cognome, Long roleId, Long id,Long teamId) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.roleId = roleId;
		this.id = id;
		this.teamId = teamId;
	}
	
	public EmployeeDto(String nome, String cognome, Long roleId, Long id) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.roleId = roleId;
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

}
