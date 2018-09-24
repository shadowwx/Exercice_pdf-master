package org.epsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.epsi.entity.Request;
import org.epsi.service.RequestService;

@Controller
@RequestMapping(value="/request")
public class ListRequestController {
	
    @Autowired
    private RequestService service;
    
    //Affiche la liste des Commandes
    @RequestMapping(method = RequestMethod.GET)
    public String display(ModelMap pModel) {
        final List<Request> lListRequest = service.getRequests();
        pModel.addAttribute("listRequest", lListRequest);
        return "listRequest";
    }
}