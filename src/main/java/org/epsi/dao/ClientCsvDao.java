package org.epsi.dao;

import java.util.List;

import org.epsi.entity.Client;

public interface ClientCsvDao {
	
	public List<Client> getClients();
	void importClient(final Client client);

}
