package org.epsi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.epsi.entity.Client;
import org.epsi.entity.CreationFromRequest;
import org.epsi.entity.Product;
import org.epsi.entity.Request;
import org.epsi.service.ClientService;
import org.epsi.service.ProductService;
import org.epsi.service.RequestService;
import org.jboss.resteasy.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CreateListRequestController {

	private Logger logger = Logger.getLogger(CreateListRequestController.class);
	
    @Autowired
    private RequestService requestService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ClientService clientService;
    
    //Affiche la page avec la liste des commandes et un formulaire pour créer une nouvelle commande
    @RequestMapping(value="/displayCreationRequest", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Product> productList = productService.getProducts();
        pModel.addAttribute("productList", productList);
        final List<Client> clientList = clientService.getClients();
        pModel.addAttribute("clientList", clientList);
        if (pModel.get("creationRequest") == null) {
            pModel.addAttribute("creationRequest", new CreationFromRequest());
        }
        return "creationRequest";
    }
    
    //Permet de créer une commande et renvoi sur la page de création de la commande avec la liste des commandes actuelle
    @RequestMapping(value="/creationRequest", method = RequestMethod.POST)
    public RedirectView create(@Valid @ModelAttribute(value="creationRequest") final CreationFromRequest creationFormRequest, 
            final BindingResult pBindingResult, final ModelMap pModel, HttpServletRequest request) {

        if (!pBindingResult.hasErrors()) {
        	requestService.persistCreateRequest(this.createRequestFromForm(creationFormRequest));
        }
        else
        {
        	System.out.println("Errors " + pBindingResult.getErrorCount());
        }
        return new RedirectView(request.getContextPath() + "/request");
    }
    
    private Request createRequestFromForm(CreationFromRequest creationFormRequest)
    {
    	Request request = new Request();
    	Client client = clientService.getIdClient(creationFormRequest.getClientId());
    	logger.info("Creation d'une requete : " + creationFormRequest.toString());
    	logger.info(client != null ? client.toString() : "client null pour la création de la requête pour l'id " + creationFormRequest.getClientId());
    	request.setClient(client);
    	request.setConfirmation(creationFormRequest.isConfirmation());
    	request.setDateCreation(creationFormRequest.getDateCreation());
    	request.setDateDelivery(creationFormRequest.getDateDelivery());
    	request.setDeliveryPlace(creationFormRequest.getDeliveryPlace());
    	request.setDetailsRequests(creationFormRequest.getDetailsRequests());
    	request.setRequest_billNumber(creationFormRequest.getRequest_billNumber());
    	logger.info(request.toString());
    	return request;
    }
}