package org.epsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.epsi.entity.Product;
import org.epsi.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ListProductController {
	
    @Autowired
    private ProductService service;

    //Affiche la liste des produits renommer en product dans le code et en BDD
    @RequestMapping(method = RequestMethod.GET)
    public String display(ModelMap pModel) {
        final List<Product> lListProduct = service.getProducts();
        pModel.addAttribute("listProduct", lListProduct);
        return "listProduct";
    }
}