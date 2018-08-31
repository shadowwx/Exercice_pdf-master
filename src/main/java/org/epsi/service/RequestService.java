package org.epsi.service;

import java.util.List;
//import java.util.Optional;

import org.epsi.entity.Request;

public interface RequestService {
	public List<Request> getRequests();
	public Request getRequest(Long request_billNumber);
}

