package org.epsi.service;

import java.util.List;

import org.epsi.entity.CreationFromRequest;
import org.epsi.entity.Request;

public interface RequestService {
	public List<Request> getRequests();
	public Request getRequest(Long request_billNumber);
	Request createRequestFromCreationFromRequest (CreationFromRequest creationFromRequest);
	public void persistCreateRequest(Request request);
	public void persistRemoveRequest(Long request_billNumber);
	public void persistEditRequest(Request request);
	public Request getFindRequestBillNumber(Long request_billNumber);
}

