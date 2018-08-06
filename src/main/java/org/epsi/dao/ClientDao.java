package org.epsi.dao;

import java.util.List;

import org.epsi.entity.Client;

public interface ClientDao {
	
	public List<Client> getClients();
	void createClient(final Client client);
	void removeClient(final Client client);
	
}
