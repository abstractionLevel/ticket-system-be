package com.ticketsystem.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="status")
	private String status;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="id_pm")
	private Employee pm;
	
	
	
//	@ManyToMany(mappedBy = "tasks")
//	private List<Employee> employees;
	
	@OneToMany(mappedBy="task")
	private List<Note> notes;
	
	public Task() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

//	public List<Employee> getDev() {
//		return dev;
//	}
//
//	public void setDev(List<Employee> dev) {
//		this.dev = dev;
//	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}

	public Employee getPm() {
		return pm;
	}

	public void setPm(Employee pm) {
		this.pm = pm;
	}
	
	
	

}
