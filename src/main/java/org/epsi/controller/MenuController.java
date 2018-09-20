package org.epsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	//Affiche un menu avec le choix de la liste des CLients/Produits/Commandes, ainsi que le traitement CSV
    @RequestMapping(method = RequestMethod.GET)
    public String displayMenu(final ModelMap pModel) {
        return "menu";
    }
}