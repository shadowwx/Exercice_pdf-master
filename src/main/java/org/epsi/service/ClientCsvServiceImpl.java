package org.epsi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.epsi.dao.ClientCsvDao;
import org.epsi.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCsvServiceImpl implements ClientCsvService {
	
	@Autowired
	private ClientCsvDao clientCsvDao;
	
	@Transactional
	public List<Client> getClients() {
		return clientCsvDao.getClients();
	}
	
    BufferedReader br = null;
    String line = null;
    String cvsSplit = ";";
	
	@Transactional
	public List<Client> readCsv(InputStream file) {

    	br = new BufferedReader(new InputStreamReader(file));
    	List<Client> clientList = new ArrayList<Client>();
        // Cette boucle permet de séparé chaque ligne et de boucler jusqu'a qu'il n'y en est plus.
			try {
				while ((line = br.readLine()) != null) {
				    // Permet de séparé les occurences
				    String[] splitClient= line.split(cvsSplit);
				    Client client = new Client(splitClient[0], splitClient[1], splitClient[2], splitClient[3], splitClient[4]);
				    clientList.add(client);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return clientList;
	}


	@Transactional
    public void persistImportClient(List<Client> client) {
		for(int i=0 ; i<client.size() ; i++) {
			clientCsvDao.importClient(client.get(i));
		}
    }
	
}