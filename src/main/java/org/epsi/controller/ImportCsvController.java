package org.epsi.controller;

import java.util.List;

import javax.validation.Valid;

import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;
import org.epsi.service.ClientCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/csv")
public class ImportCsvController {

	@Autowired
	private ClientCsvService clientCsvService;

	@RequestMapping(method = RequestMethod.GET)
	public String display(ModelMap pModel) {
		final List<Client> lListClient = clientCsvService.getClients();
		pModel.addAttribute("listClient", lListClient);
		if (pModel.get("importCsv") == null) {
			pModel.addAttribute("importCsv", new CreationFromClient());
		}
		return "Csv";
	}

	@RequestMapping(value="/importCsv", method = RequestMethod.POST)
	public String importCsv(@Valid @ModelAttribute(value="importCsv") final CreationFromClient importCsv, 
			final BindingResult pBindingResult, final ModelMap pModel) {

		if (!pBindingResult.hasErrors()) {       
			Client client = clientCsvService.readCsv(importCsv);
			if(client == null) {
				System.out.println("Une erreur sur le fichier CSV est présent");
			}
			clientCsvService.persistImportClient(client);
		}
		return display(pModel);
	}
}