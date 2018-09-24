package org.epsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.epsi.entity.Client;
import org.epsi.service.ClientService;

@Controller
@RequestMapping("/client")
public class ListClientController {
	
    @Autowired
    private ClientService service;

    //Affiche la liste des clients
    @RequestMapping(method = RequestMethod.GET)
    public String display(ModelMap pModel) {
        final List<Client> lListClient = service.getClients();
        pModel.addAttribute("listClient", lListClient);
        return "listClient";
    }
}