package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.Category;
public interface CategoryDAO {
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(int categoryId);
	Category getCategoryById(int categoryId);
	List<Category>getAllCategory();
}