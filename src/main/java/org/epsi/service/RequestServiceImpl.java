package org.epsi.service;

import java.util.List;
//import java.util.Optional;

import org.epsi.dao.RequestDao;
import org.epsi.entity.CreationFromRequest;
import org.epsi.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestDao requestDao;

	@Transactional(readOnly=true)
	public List<Request> getRequests() {
		return requestDao.getRequests();
	}
	
	//appel la listes des Requests possédant le numéro de commande (billNumber)
	@Override
	public Request getRequest(Long request_billNumber) {		
		Request lRequest = null;
		 List<Request> rlist = requestDao.getRequests();
	        
	        //pour chaque client, verifie ID
	        //SI id = parametre -> lCLient = ce client
	        		 
	        //TODO regarder la fonctionnalit� stream de java 8

	        for(Request requestCourant : rlist) {
	        	//traitementt
	        	if(requestCourant.getRequest_billNumber().equals(request_billNumber)) {
	        		lRequest = requestCourant;
	        		break;
	        	}
	        	 
	        }
	        //retourne ce client 
	        return lRequest;
		}
	
	@Transactional
    public void persistCreateRequest(Request request) {
        requestDao.createRequest(request);
    }
	
	@Transactional
	public void persistRemoveRequest(Long request_billNumber) {
		final Request lRequest = new Request();
		lRequest.setRequest_billNumber(request_billNumber);
        
		requestDao.removeRequest(lRequest);
	}
	
	//Envoi les données tiré du fichier en BDD
	public void persistEditRequest(Request request) {
		requestDao.editRequest(request);
	}
	
	public Request getFindRequestBillNumber(Long request_billNumber) {
		Request lRequest = null;
		
		//recupération liste Requests		
        List<Request> rlist = requestDao.getRequests();

        for(Request requestCourant : rlist) {
        	//traitement
        	if(requestCourant.getRequest_billNumber().equals(request_billNumber)) {
        		lRequest = requestCourant;
        		break;
        	}
        }
        //retourne cette commande
        return lRequest;
	}
}