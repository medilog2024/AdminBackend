package com.mladmin.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SUBSCRIPTION_MASTER")
public class SubscriptionMaster {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  // Primary key with auto-increment
	
	@Column(name = "plan_name", nullable = false)  // Mapping the 'plan_name' column in the table
	private String planName;
	
	@Column(name = "description")  // Mapping the 'description' column in the table
	private String description;
	
	@Column(name = "price", nullable = false)  // Mapping the 'price' column in the table
	private Float price;
	
	@Column(name = "duration", nullable = false)  // Mapping the 'duration' column in the table
	private String duration;
	
	@Column(name = "created_at", nullable = false)  // Mapping the 'created_at' column in the table
	private String createdAt;
	
	@Column(name = "updated_at")  // Mapping the 'updated_at' column in the table
	private String updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
 
}
