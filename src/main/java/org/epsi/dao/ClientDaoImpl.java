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

import org.epsi.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public void editClient(final Client client) {

		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		
        final CriteriaUpdate<Client> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Client.class);     
        final Root<Client> lRoot = lCriteriaUpdate.from(Client.class);
        final Path<Client> lPath = lRoot.get("client_id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, client.getClient_id());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("name", client.getName());
        lCriteriaUpdate.set("firstName", client.getFirstName());
        lCriteriaUpdate.set("billingPlace", client.getBillingPlace());
        lCriteriaUpdate.set("mail", client.getMail());
        lCriteriaUpdate.set("phone", client.getPhone());
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