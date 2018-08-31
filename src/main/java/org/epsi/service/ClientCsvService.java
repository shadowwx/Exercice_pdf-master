package org.epsi.service;

import java.io.InputStream;
import java.util.List;

import org.epsi.entity.Client;

public interface ClientCsvService {

	public List<Client> getClients();
	public List<Client> readCsv(InputStream file);
	public void persistImportClient(List<Client> client);
}
