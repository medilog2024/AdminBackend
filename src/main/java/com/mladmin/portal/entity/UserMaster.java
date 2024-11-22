package com.mladmin.portal.entity;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ADMIN_MASTER")
public class UserMaster {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  
    private String password;
    
    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId; // email is unique

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "UserMaster [id=" + id + ", password=" + password + ", emailId=" + emailId + "]";
	}
     
	
}
