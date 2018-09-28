package org.epsi.controller;

import java.util.List;

import javax.validation.Valid;

import org.epsi.entity.CreationFromRequest;
import org.epsi.entity.Request;
import org.epsi.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateListRequestController {

    @Autowired
    private RequestService requestservice;
    
    //Affiche la page avec la liste des commandes et un formulaire pour créer une nouvelle commande
    @RequestMapping(value="/displayCreationRequest", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Request> lListRequest = requestservice.getRequests();
        pModel.addAttribute("listRequest", lListRequest);
        if (pModel.get("creationRequest") == null) {
            pModel.addAttribute("creationRequest", new CreationFromRequest());
        }
        return "creationRequest";
    }
    
    //Permet de créer une commande et renvoi sur la page de création de la commande avec la liste des commandes actuelle
    @RequestMapping(value="/creationRequest", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="creationRequest") final CreationFromRequest creation, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
        	Request request = requestservice.createRequestFromCreationFromRequest(creation);
        	requestservice.persistCreateRequest(request);
        }
        return display(pModel);
        }
}