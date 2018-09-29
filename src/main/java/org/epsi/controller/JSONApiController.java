package org.epsi.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.epsi.entity.Client;
import org.epsi.service.ClientService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jsonApi")
public class JSONApiController {
	
	 @Autowired
	 private ClientService service;
	 
	 @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<byte[]> getJSONClients(ModelMap pModel)
    {
    	JSONArray clients = new JSONArray();
    	final List<Client> lListClient = service.getClients();
    	lListClient.stream().forEach(client -> clients.put(this.getJSONFromClient(client)));
    	HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/json"));
	    return new ResponseEntity<>(clients.toString().getBytes(StandardCharsets.UTF_8), headers, HttpStatus.OK);
    }
    
    public JSONObject getJSONFromClient(Client client)
    {
    	JSONObject clientJSON = new JSONObject();
    	
    	clientJSON.put("name", client.getName());
    	clientJSON.put("firstName", client.getFirstName());
    	clientJSON.put("mail", client.getMail());
    	clientJSON.put("id", client.getClient_id());
    	return clientJSON;
    }

}
