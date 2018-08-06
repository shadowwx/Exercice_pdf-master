package org.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.epsi.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientCsvDaoImpl implements ClientCsvDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Client> getClients() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Client> lCriteriaQuery = lCriteriaBuilder.createQuery(Client.class);
		final Root<Client> lRoot = lCriteriaQuery.from(Client.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Client> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

		return lTypedQuery.getResultList();
	}

	public void importClient(final Client client) {
		entityManager.persist(client);
	}
		
}