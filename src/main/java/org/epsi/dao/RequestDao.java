package org.epsi.dao;

import java.util.List;
//import java.util.Optional;

import org.epsi.entity.Request;

public interface RequestDao {
	public List<Request> getRequests();
	void createRequest(final Request request);
	void removeRequest(final Request request);
	void editRequest(final Request request);

}
