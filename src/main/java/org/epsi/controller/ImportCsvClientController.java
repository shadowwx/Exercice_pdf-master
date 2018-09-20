package org.epsi.controller;

import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.epsi.entity.Client;
import org.epsi.service.ClientCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImportCsvClientController {

	@Autowired
	private ClientCsvService clientUpload;
	
	//Affiche un menu interactif pour l'utilisateur permettant de choisir un fichier sur son ordinateur
	@RequestMapping(value="/client-csv", method = RequestMethod.GET)
	public String displayClient(ModelMap pModel) {
		return "importCsvClient";
	}
	
	//Permet de traiter le fichier Client en format CSV et d'ajouter les données en BDD
	@RequestMapping(value="/uploadCsvClient", method = RequestMethod.POST)
	public String importCsvClient(@Valid @ModelAttribute(value="uploadCsvClient") @RequestParam MultipartFile file) {		
		try {
		InputStream tmp = file.getInputStream();
		List<Client> client = clientUpload.readCsvClient(tmp);
		clientUpload.persistImportClient(client);
		return "redirect:client";
		} catch(Exception e) {
			e.printStackTrace();
			return "errorCsv";
		}
	}
}