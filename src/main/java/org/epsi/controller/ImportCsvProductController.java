package org.epsi.controller;

import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.epsi.entity.Product;
import org.epsi.service.ProductCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImportCsvProductController {

	@Autowired
	private ProductCsvService productUpload;
	
	//Affiche un menu interactif pour l'utilisateur permettant de choisir un fichier sur son ordinateur
	@RequestMapping(value="/product-csv", method = RequestMethod.GET)
	public String displayProduct(ModelMap pModel) {
		return "importCsvProduct";
	}

	//Permet de traiter le fichier Product en format CSV et d'ajouter les données en BDD
	@RequestMapping(value="/uploadCsvProduct", method = RequestMethod.POST)
	public String importCsvProduct(@Valid @ModelAttribute(value="uploadCsvProduct") @RequestParam MultipartFile file) {		
		try {
		InputStream tmp = file.getInputStream();
		List<Product> product = productUpload.readCsvProduct(tmp);
		productUpload.persistImportProduct(product);
		return "redirect:product";
		} catch(Exception e) {
			e.printStackTrace();
			return "errorCsv";
		}
	}
}