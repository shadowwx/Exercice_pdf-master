package org.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.epsi.entity.Request;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDaoImpl implements RequestDao {

	@PersistenceContext
	private EntityManager entityManager;

	//Liste des commandes
	public List<Request> getRequests() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Request> lCriteriaQuery = lCriteriaBuilder.createQuery(Request.class);
		final Root<Request> lRoot = lCriteriaQuery.from(Request.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Request> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}		
}