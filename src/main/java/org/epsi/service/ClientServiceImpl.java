package org.epsi.service;

import java.util.List;
//import java.util.Optional;

import org.epsi.dao.ClientDao;
import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Transactional(readOnly=true)
	public List<Client> getClients() {
		return clientDao.getClients();
	}

    @Transactional
    public Client createClientFromCreationFromClient(CreationFromClient creationFromClient) {
        final Client lClient = new Client();
        lClient.setName(creationFromClient.getName());
        lClient.setFirstName(creationFromClient.getFirstName());
        lClient.setBillingPlace(creationFromClient.getBillingPlace());
        lClient.setMail(creationFromClient.getMail());
        lClient.setPhone(creationFromClient.getPhone());
        
        return lClient;
        
    }
    
    @Transactional
    public void removeClient(final Long client_id) {
        final Client lClient = new Client();
        lClient.setClient_id(client_id);

        clientDao.removeClient(lClient);
    }
    
    @Transactional
    public void persistCreateClient(Client client) {
        clientDao.createClient(client);
    }
    
    
    
}