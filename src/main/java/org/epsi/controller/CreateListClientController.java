package org.epsi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.epsi.entity.Client;
import org.epsi.entity.CreationFromClient;
import org.epsi.service.ClientService;

@Controller
public class CreateListClientController {
	
    @Autowired
    private ClientService service;
    
    @RequestMapping(value="/displayCreationClient", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Client> lListClient = service.getClients();
        pModel.addAttribute("listClient", lListClient);
        if (pModel.get("creationClient") == null) {
            pModel.addAttribute("creationClient", new CreationFromClient());
        }
        return "creationClient";
    }
    
    @RequestMapping(value="/creationClient", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="creationClient") final CreationFromClient creation, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            Client client = service.createClientFromCreationFromClient(creation);
            service.persistCreateClient(client);
        }
        return display(pModel);
        }
}