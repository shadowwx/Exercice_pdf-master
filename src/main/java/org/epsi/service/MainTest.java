package org.epsi.service;

import java.util.ArrayList;
import java.util.List;

import org.epsi.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class MainTest {
	
	@Autowired
	public static ClientService clientService;

	public static void main(String[] args){
		String line1 = "Dupont;Jean;1 rue des fougéres;dupont.jean@lelol.com;04.23.35.61.12";
		String line2 = "Darmond;Gérard;73 rue des artiste;gerard.darmond@lelol.com;03.19.32.61.12";
		String line3 = "Leponge;Bob;3 rue des Ananas sous la mer;bob.sponge@nickelodeon.com;01.36.51.19.21";
		List<String> fichier = new ArrayList<String>();
		
		fichier.add(line1);
		fichier.add(line2);
		fichier.add(line3);
		
		for(String line : fichier) {
			String[] splittedLine = line.split(";");
			System.out.println(splittedLine[0]);
			Client client = new Client(splittedLine[0], splittedLine[1], splittedLine[2], splittedLine[3], splittedLine[4]);
			clientService.persistCreateClient(client);
		}
		
	}
	
	
	
}
