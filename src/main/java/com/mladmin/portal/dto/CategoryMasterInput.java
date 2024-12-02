package com.mladmin.portal.dto; // Ensure this matches your package structure

public class CategoryMasterInput {
	
		private int categoryId;
	    private String categoryName;
	    
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
	     
}
