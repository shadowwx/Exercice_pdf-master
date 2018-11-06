package org.epsi.controller;

import java.util.List;

import org.epsi.entity.Request;
import org.epsi.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveListRequestController {

	@Autowired
    private RequestService requestService;
	
	//Affiche la liste des commandes à supprimer
    @RequestMapping(value="/displayRemoveRequest", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Request> lListRequest = requestService.getRequests();
        pModel.addAttribute("listRequest", lListRequest);
        return "removeRequest";
    }

    //Delete en BDD la commande choisi
    @RequestMapping(value="/removeRequest", method = RequestMethod.GET)
    public String remove(@RequestParam(value="request_billNumber") final Long request_billNumber, final ModelMap pModel) {
    	requestService.persistRemoveRequest(request_billNumber);  
    	return display(pModel);
    }

}