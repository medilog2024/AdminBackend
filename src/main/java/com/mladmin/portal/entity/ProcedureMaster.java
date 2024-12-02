package com.mladmin.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PROCEDURE_MASTER")
public class ProcedureMaster {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                           
 
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 
}
