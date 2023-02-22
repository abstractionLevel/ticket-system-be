package com.ticketsystem.dto;

public class NoteDto {
	
	private String descrizione;
	private Long developerId;
	private String nome;
	private String cognome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long id;

	public NoteDto() {}
	
	public NoteDto(String description, Long developerId) {
		super();
		this.descrizione = description;
		this.developerId = developerId;
	}
	
	public NoteDto(String description, String devName, String devCognome) {
		super();
		this.descrizione = description;
		this.nome = devName;
		this.cognome = devCognome;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String description) {
		this.descrizione = description;
	}
	public Long getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Long developerId) {
		this.developerId = developerId;
	}
	
	
	public String getName() {
		return nome;
	}

	public void setName(String devName) {
		this.nome = devName;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String devCognome) {
		this.cognome = devCognome;
	}


}
