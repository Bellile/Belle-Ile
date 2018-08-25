package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accueil")
public class AfficherAccueilController {
	
	
	@RequestMapping(value="/showAccueil", method=RequestMethod.GET)
	private ModelAndView affichAccueil(){
		
		return new ModelAndView("accueil");
	}
	
	
	
	

}
