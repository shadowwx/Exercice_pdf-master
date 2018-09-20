package org.epsi.controller;

import javax.validation.Valid;

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
	
//	@RequestMapping(value="/client1", method = RequestMethod.GET)
//    public String clientForm(Model model) {
//        model.addAttribute("client1", new Client());
//        return "client1";
//    }
//
//	@RequestMapping(value="/client1", method = RequestMethod.POST)
//    public String clientSubmit(@ModelAttribute Client client) {
//        return "result";
//    }
	
	
	
	

	@Autowired
    private ClientService clientService;

    @RequestMapping(value="/displayEditClient/{clientId}", method = RequestMethod.GET)
    public String display(@PathVariable(value="clientId") final Long clientId, ModelMap pModel) {
    	Client client = clientService.getIdClient(clientId);
    	pModel.addAttribute("editClient", client);
        return "editClient";
    }
    
    @RequestMapping(value="/editClient", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute(value="client") Client editFromClient,/* final EditForm edit,*/ 
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
        return "display";
    }
}