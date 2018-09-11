package org.epsi.dao;

import java.util.List;

import org.epsi.entity.Product;

public interface ProductCsvDao {

	public List<Product> getProducts();
	void importProduct(final Product product);

}
