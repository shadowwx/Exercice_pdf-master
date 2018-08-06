package org.epsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
    @RequestMapping(method = RequestMethod.GET)
    public String displayMenu(final ModelMap pModel) {
        return "menu";
    }
}