package org.epsi.controller;

import java.util.List;
import org.epsi.entity.Client;

import org.epsi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveListClientController {

	@Autowired
    private ClientService service;
	
	//Affiche la liste des clients à supprimer
    @RequestMapping(value="/displayRemoveClient", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Client> lListClient = service.getClients();
        pModel.addAttribute("listClient", lListClient);
        return "removeClient";
    }

    //Traitement qui supprime les clients
    @RequestMapping(value="/removeClient", method = RequestMethod.GET)
    public String remove(@RequestParam(value="client_id") final Long client_id, final ModelMap pModel) {
    	service.removeClient(client_id);  
    	return display(pModel);
    }
}
