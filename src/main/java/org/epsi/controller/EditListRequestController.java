package org.epsi.controller;

import org.epsi.entity.Request;
import org.epsi.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditListRequestController {

	@Autowired
    private RequestService RequestService;

	//Affiche la page de modification liée à l'ID choisi
    @RequestMapping(value="/displayEditRequest/{request_billNumber}", method = RequestMethod.GET)
    public String display(@PathVariable(value="request_billNumber") final Long request_billNumber, ModelMap pModel) {
    	Request Request = RequestService.getFindRequestBillNumber(request_billNumber);
    	pModel.addAttribute("editRequest", Request);
        return "editRequest";
    }
    
    //Créer une update en BDD
    @RequestMapping(value="/displayEditRequest/editRequest", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value="editRequest") Request editFromRequest,
            final BindingResult pBindingResult, final ModelMap pModel) {
        if (!pBindingResult.hasErrors()) {
        	Request lRequest = RequestService.getFindRequestBillNumber(editFromRequest.getRequest_billNumber());
    		lRequest.setRequest_billNumber(editFromRequest.getRequest_billNumber());
    		lRequest.setDateCreation(editFromRequest.getDateCreation());
    		lRequest.setDateDelivery(editFromRequest.getDateDelivery());
    		lRequest.setConfirmation(editFromRequest.getConfirmation());
    		lRequest.setDeliveryPlace(editFromRequest.getDeliveryPlace());
    		lRequest.setClient(editFromRequest.getClient());
        	
            final Request editedRequest = lRequest;
        	RequestService.persistEditRequest(editedRequest);
        }
        return "redirect:/Request";
    }
}
