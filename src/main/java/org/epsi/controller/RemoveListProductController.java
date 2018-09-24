package org.epsi.controller;

import java.util.List;

import org.epsi.entity.Product;
import org.epsi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveListProductController {
	
	@Autowired
    private ProductService service;
	
	//Affiche la liste des produits à supprimer
    @RequestMapping(value="/displayRemoveProduct", method = RequestMethod.GET)
    public String display(final ModelMap pModel) {
        final List<Product> lListProduct = service.getProducts();
        pModel.addAttribute("listProduct", lListProduct);
        return "removeProduct";
    }
    
    //Delete en BDD le produit choisi
    @RequestMapping(value="/removeProduct", method = RequestMethod.GET)
    public String remove(@RequestParam(value="product_reference") final Long product_reference, final ModelMap pModel) {
        service.removeProduct(product_reference);;
        return display(pModel);
    }
}