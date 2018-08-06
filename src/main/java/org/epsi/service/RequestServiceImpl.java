package org.epsi.service;

import java.util.List;
//import java.util.Optional;

import org.epsi.dao.RequestDao;
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
}
