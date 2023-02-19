package com.ticketsystem.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "badge")
public class Badge {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "numero")
    private String numero;
    
    @OneToOne
    @JoinColumn(name="id_employee")
    private Employee employee;
    
    @OneToMany(mappedBy = "badge")
    private List<TimeLog> timeLog;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<TimeLog> getTimeLog() {
		return timeLog;
	}

	public void setTimeLog(List<TimeLog> timeLog) {
		this.timeLog = timeLog;
	}
    
    
}
