package org.epsi.service;

import java.util.List;

import org.epsi.dao.TvaDao;
import org.epsi.entity.Tva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TvaServiceImpl implements TvaService {
	
	@Autowired
	private TvaDao tvaDao;

	@Transactional(readOnly=true)
	public List<Tva> getTva() {
		return tvaDao.getTva();
	}
}
