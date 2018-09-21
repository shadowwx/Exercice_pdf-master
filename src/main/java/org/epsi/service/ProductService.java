package org.epsi.service;

import java.util.List;

import org.epsi.entity.CreationFromProduct;
import org.epsi.entity.Product;

public interface ProductService {
	public List<Product> getProducts();
	Product createProductFromCreationFromProduct(CreationFromProduct creationFromProduct);
	public Product getFindProductReference(Long product_reference);
	void removeProduct(final Long product_reference);
	public boolean checkCreationFromProduct(CreationFromProduct creationFromProduct);
	public void persistProduct(Product product);
	public void persistEditProduct(Product product);
	
}
