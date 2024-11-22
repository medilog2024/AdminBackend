package com.mladmin.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HOSPITAL_MASTER")
public class HospitalMaster {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                           

    private String name;                      

    private String location;                  

    private String contactNumber;             

    private String email;                     

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "HospitalMaster [id=" + id + ", name=" + name + ", location=" + location + ", contactNumber="
				+ contactNumber + ", email=" + email + "]";
	}

	
	
}
