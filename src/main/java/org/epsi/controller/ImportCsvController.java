package org.epsi.controller;

import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.epsi.entity.Client;
import org.epsi.service.ClientCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImportCsvController {

	@Autowired
	private ClientCsvService upload;
	
	@RequestMapping(value="/csv", method = RequestMethod.GET)
	public String display(ModelMap pModel) {
		return "importCsv";
	}

	@RequestMapping(value="/uploadCsv", method = RequestMethod.POST)
	public String importCsv(@Valid @ModelAttribute(value="uploadCsv") @RequestParam MultipartFile file) {		
		try {
		InputStream tmp = file.getInputStream();
		List<Client> client = upload.readCsv(tmp);
		upload.persistImportClient(client);
		return "redirect:client";
		} catch(Exception e) {
			e.printStackTrace();
			return "errorCsv";
		}
	}
}