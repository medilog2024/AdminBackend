package com.mladmin.portal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY_MASTER")
public class CategoryMaster {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                           
 
	@Column(name = "category_name", nullable = false)
	private String categoryName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryMaster [id=" + id + ", categoryName=" + categoryName + "]";
	}  
	
}
