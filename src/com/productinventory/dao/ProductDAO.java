package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.Product;

public interface ProductDAO{
	boolean addProduct(Product product);
	boolean deleteProduct(int productId);
	boolean updateProduct(Product product);
	public Product getProductById(int productId);
	List<Product> getAllProducts();
}
