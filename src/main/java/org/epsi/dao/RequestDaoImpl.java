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

import org.epsi.entity.Request;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public void createRequest(Request request) {
		entityManager.persist(request);   
	}
	
	public void removeRequest(Request request) {
		entityManager.persist(request);   
	}
	
	@Transactional
    public void editRequest(final Request request) {
		
    	final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		
        final CriteriaUpdate<Request> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Request.class);     
        final Root<Request> lRoot = lCriteriaUpdate.from(Request.class);
        final Path<Request> lPath = lRoot.get("request_billNumber");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, request.getRequest_billNumber());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("request_billNumber", request.getRequest_billNumber());
        lCriteriaUpdate.set("dateCreation", request.getDateCreation());
        lCriteriaUpdate.set("dateDelivery", request.getDateDelivery());
        lCriteriaUpdate.set("confirmation", request.getConfirmation());
        lCriteriaUpdate.set("deliveryPlace", request.getDeliveryPlace());
        lCriteriaUpdate.set("client_id", request.getClient());

        final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        lQuery.executeUpdate();
        
    }
}