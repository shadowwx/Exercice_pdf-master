package org.epsi.service;

import java.util.List;

import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;

public interface ClientCsvService {

	public List<Client> getClients();
	public Client readCsv(CreationFromClient importCsv);
	public void persistImportClient(Client client);
}
