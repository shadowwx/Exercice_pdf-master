package org.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.epsi.entity.Tva;
import org.springframework.stereotype.Repository;

@Repository
public class TvaDaoImpl implements TvaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Tva> getTva(){
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Tva> lCriteriaQuery = lCriteriaBuilder.createQuery(Tva.class);
		final Root<Tva> lRoot = lCriteriaQuery.from(Tva.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Tva> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}
}