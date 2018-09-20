package org.epsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	//Affiche la page d'accueil
    @RequestMapping(method = RequestMethod.GET)
    public String displayHome(ModelMap pModel) {
        return "home";
    }
}
