package org.epsi.controller;

import org.epsi.entity.Client;
import org.epsi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditListClientController {

	@Autowired
    private ClientService clientService;

	//Affiche la page de modification liée à l'ID choisi
    @RequestMapping(value="/displayEditClient/{clientId}", method = RequestMethod.GET)
    public String display(@PathVariable(value="clientId") final Long clientId, ModelMap pModel) {
    	Client client = clientService.getIdClient(clientId);
    	pModel.addAttribute("editClient", client);
        return "editClient";
    }
    
    //Créer une update en BDD
    @RequestMapping(value="/displayEditClient/editClient", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value="editClient") Client editFromClient,
            final BindingResult pBindingResult, final ModelMap pModel) {
        if (!pBindingResult.hasErrors()) {
        	Client lClient = clientService.getIdClient(editFromClient.getClient_id());
        	lClient.setName(editFromClient.getName());
            lClient.setFirstName(editFromClient.getFirstName());
            lClient.setBillingPlace(editFromClient.getBillingPlace());
            lClient.setMail(editFromClient.getMail());
            lClient.setPhone(editFromClient.getPhone());
        	
            final Client editedClient = lClient;
        	clientService.persistEditClient(editedClient);
        }
        return "redirect:/client";
    }
}