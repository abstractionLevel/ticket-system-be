package com.ticketsystem.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="nome")
	private String nome;

	@Column(name="cognome")
	private String cognome;
	
	@ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    
	@ManyToOne
	@JoinColumn(name = "id_team")
	private Team team;
	
	@OneToOne(mappedBy="pm")
	private Project project;
	
	@OneToOne(mappedBy="employee")
	private Badge badge;
	
	
	@OneToMany(mappedBy = "pm")
    private List<Task> tasks;
	
	@ManyToOne()
	@JoinColumn(name="id_company")
	private Company company;
	
	@OneToMany(mappedBy="dev")
	private List<Note> notes;

	public Employee(String nome, String cognome, Role role) {
		this.nome=nome;
		this.cognome=cognome;
		this.role=role;
	}

	public Role getRole() {
		return role;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
	

}
