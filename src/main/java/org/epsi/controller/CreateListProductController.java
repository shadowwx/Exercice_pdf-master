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
import org.epsi.entity.CreationFromProduct;
import org.epsi.service.ProductService;

@Controller
public class CreateListProductController {

    @Autowired
    private ProductService service;
    
    @RequestMapping(value="/displayCreationProduct", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Product> lListProduct = service.getProducts();
        pModel.addAttribute("listProduct", lListProduct);
        if (pModel.get("creationProduct") == null) {
            pModel.addAttribute("creationProduct", new CreationFromProduct());
        }
        return "creationProduct";
    }
    
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