package org.epsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public String login(final ModelMap pModel)
	{
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String loginPost(final ModelMap pModel)
	{
		return "home";
	}
	
}
