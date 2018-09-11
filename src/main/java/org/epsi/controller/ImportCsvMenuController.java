package org.epsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/csv")
public class ImportCsvMenuController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(ModelMap pModel) {
		return "importCsvMenu";

	}
}