package org.epsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.epsi.entity.Request;
import org.epsi.service.RequestService;

@Controller
@RequestMapping("/request")
public class ListRequestController {
	
    @Autowired
    private RequestService requestService;
    
    //Affiche la liste des Commandes
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView display(ModelMap pModel) {
        final List<Request> lListRequest = requestService.getRequests();
        pModel.addAttribute("listRequest", lListRequest);
        return new ModelAndView("listRequest");
    }
}