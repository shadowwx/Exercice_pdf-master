package org.epsi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.epsi.entity.Product;
import org.epsi.entity.Tva;
import org.epsi.entity.CreationFromProduct;
import org.epsi.service.ProductService;
import org.epsi.service.TvaService;

@Controller
public class CreateListProductController {

    @Autowired
    private ProductService service;
    
    @Autowired
    private TvaService tvaService;
    
    //Affiche la page avec la liste des produits et un formulaire pour créer un nouveau produit
    @RequestMapping(value="/displayCreationProduct", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
    	final List<Tva> tvaList = tvaService.getTva();
        pModel.addAttribute("tvaList", tvaList);
        final List<Product> lListProduct = service.getProducts();
        pModel.addAttribute("listProduct", lListProduct);
        if (pModel.get("creationProduct") == null) {
            pModel.addAttribute("creationProduct", new CreationFromProduct());
        }
        return "creationProduct";
    }
    
    //Permet de créer un produit et renvoi sur la page de création de produit avec la liste des produits actuelle
    @RequestMapping(value="/creationProduct", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="creationProduct") final CreationFromProduct creation, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
        	boolean isObjectOk = service.checkCreationFromProduct(creation);
        	if(isObjectOk == true) {
        		Product product = service.createProductFromCreationFromProduct(creation);
        		service.persistProduct(product);
        	}
        	
        }
        return display(pModel);
        }    
    
}