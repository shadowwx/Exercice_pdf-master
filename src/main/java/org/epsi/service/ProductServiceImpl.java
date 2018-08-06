package org.epsi.service;

import java.util.List;

import org.epsi.dao.ProductDao;
import org.epsi.entity.CreationFromProduct;
import org.epsi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Transactional(readOnly=true)
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
    
    public Product createProductFromCreationFromProduct(CreationFromProduct creationFromProduct) {
        final Product lProduct = new Product();
        lProduct.setName(creationFromProduct.getName());
        lProduct.setBrand(creationFromProduct.getBrand());
        lProduct.setType(creationFromProduct.getType());
        lProduct.setWeight(creationFromProduct.getWeight() != null && !creationFromProduct.getWeight().isEmpty() ? Float.valueOf(creationFromProduct.getWeight()) : 0);
        lProduct.setNumberStock(Integer.valueOf(creationFromProduct.getNumberStock()));
        lProduct.setPriceUnit(Float.valueOf(creationFromProduct.getPriceUnit()));
        lProduct.setCommentary(creationFromProduct.getCommentary());

        return lProduct;
    }
    @Transactional
    public void persistProduct(Product product) {
        productDao.createProduct(product);
    }
    
    @Transactional
    public void removeProduct(final Long product_reference) {
        final Product lProduct = new Product();
        lProduct.setProduct_reference(product_reference);

        productDao.removeProduct(lProduct);
    }
    @Transactional
    public boolean checkCreationFromProduct(CreationFromProduct creationFromProduct) { 	
    	boolean isNameOk = creationFromProduct.getName() != null && !creationFromProduct.getName().isEmpty();
    	boolean isBrandOk = creationFromProduct.getBrand() != null && !creationFromProduct.getBrand().isEmpty();
    	boolean isTypeOk = creationFromProduct.getType() != null && !creationFromProduct.getType().isEmpty();
    	boolean isNumberStockOk = creationFromProduct.getNumberStock() != null && !creationFromProduct.getNumberStock().isEmpty();
    	boolean isPriceUnitOk = creationFromProduct.getPriceUnit() != null && !creationFromProduct.getPriceUnit().isEmpty();
    	
    	boolean result = isNameOk && isBrandOk && isTypeOk && isNumberStockOk && isPriceUnitOk;
    	return result;
    }

}