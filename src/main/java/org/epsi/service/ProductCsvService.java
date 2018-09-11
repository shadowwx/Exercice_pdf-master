package org.epsi.service;

import java.io.InputStream;
import java.util.List;

import org.epsi.entity.Product;

public interface ProductCsvService {

	public List<Product> getProducts();
	public List<Product> readCsvProduct(InputStream file);
	public void persistImportProduct(List<Product> product);
}
