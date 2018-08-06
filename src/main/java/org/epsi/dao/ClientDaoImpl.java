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
public class ClientDaoImpl implements ClientDao {

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

	public void createClient(final Client client) {
		entityManager.persist(client);
	}

	public void removeClient(final Client client) {
		final Client lClient = entityManager.getReference(Client.class, client.getClient_id());
		entityManager.remove(lClient);
	}
	
}