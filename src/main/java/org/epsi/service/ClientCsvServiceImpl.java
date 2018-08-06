package org.epsi.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.epsi.dao.ClientCsvDao;
import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;
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
	
	String csvFile = "fichier";
    BufferedReader br = null;
    String line = "";
    String cvsSplit = ";";
	
	@Transactional
	public Client readCsv(CreationFromClient importCsv) {

    	//Permet de mettre le fichier dans un flux en entrée.
			try {
				br = new BufferedReader(new FileReader(csvFile));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
        
        // Cette boucle permet de séparé chaque ligne et de boucler jusqu'a qu'il n'y en est plus.
			try {
				while ((line = br.readLine()) != null) {

				    // Permet de séparé les occurences
				    String[] splitClient= line.split(cvsSplit);
					Client client = new Client(splitClient[0], splitClient[1], splitClient[2], splitClient[3], splitClient[4]);
				    return client;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
        
	
	@Transactional
    public void persistImportClient(Client client) {
		clientCsvDao.importClient(client);
    }
	
}