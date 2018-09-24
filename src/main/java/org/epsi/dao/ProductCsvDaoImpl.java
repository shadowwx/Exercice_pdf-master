package org.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.epsi.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCsvDaoImpl implements ProductCsvDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	//Selectionne les produits en BDD
	public List<Product> getProducts() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Product> lCriteriaQuery = lCriteriaBuilder.createQuery(Product.class);
		final Root<Product> lRoot = lCriteriaQuery.from(Product.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Product> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}

	
	public void importProduct(final Product product) {
		entityManager.persist(product);
	}
	
}