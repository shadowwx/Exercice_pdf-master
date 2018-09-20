package org.epsi.dao;

import java.util.List;

import org.epsi.entity.Client;

public interface ClientDao {
	
	List<Client> getClients();
	void createClient(final Client client);
	void removeClient(final Client client);
	void editClient(final Client client);
}
