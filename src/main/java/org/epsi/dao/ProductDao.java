package org.epsi.dao;

import java.util.List;

import org.epsi.entity.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	void createProduct(final Product product);
	void removeProduct(final Product product);
}
