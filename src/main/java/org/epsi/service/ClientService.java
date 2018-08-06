package org.epsi.service;

import java.util.List;

import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;

public interface ClientService {
	public List<Client> getClients();
	Client createClientFromCreationFromClient(CreationFromClient creationFromClient);
	public void removeClient(Long client_id);
	public void persistCreateClient(Client client);
	
}
