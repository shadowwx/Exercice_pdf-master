package org.epsi.service;

import java.util.List;

import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;

public interface ClientService {
	List<Client> getClients();
	Client createClientFromCreationFromClient(CreationFromClient creationFromClient);
	public Client getIdClient(Long clientId);
	public void removeClient(Long client_id);
	public void persistCreateClient(Client client);
	public void persistEditClient(Client listeClient);
	//public void persistEditClient(List<Client> listeClient);
	
}
