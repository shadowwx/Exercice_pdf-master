package org.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.epsi.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Product> getProducts() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Product> lCriteriaQuery = lCriteriaBuilder.createQuery(Product.class);
		final Root<Product> lRoot = lCriteriaQuery.from(Product.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Product> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}	

    public void createProduct(final Product product) {
        entityManager.persist(product);       
    }
	
    public void removeProduct(final Product product) {
        final Product lProduct = entityManager.getReference(Product.class, product.getProduct_reference());
        entityManager.remove(lProduct);
    }
    
    @Transactional
    public void editProduct(final Product product) {
		
    	final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		
        final CriteriaUpdate<Product> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Product.class);     
        final Root<Product> lRoot = lCriteriaUpdate.from(Product.class);
        final Path<Product> lPath = lRoot.get("product_reference");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, product.getProduct_reference());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("name", product.getName());
        lCriteriaUpdate.set("brand", product.getBrand());
        lCriteriaUpdate.set("type", product.getType());
        lCriteriaUpdate.set("weight", product.getWeight());
        lCriteriaUpdate.set("numberStock", product.getNumberStock());
        lCriteriaUpdate.set("priceUnit", product.getPriceUnit());
        lCriteriaUpdate.set("commentary", product.getCommentary());
        //lCriteriaUpdate.set("tva", product.getTva());
        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        //Définir l'utilité de ce code
        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
            final String lSql = lHQuery.getQueryString();
            throw new RuntimeException("Nombre d'occurences (" + lRowCount + 
                    ") modifiés différent de 1 pour " + lSql);
        }
    }
}