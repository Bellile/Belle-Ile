package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConnexionController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String afficheFormLogin() {

		return "loginPage";
	}
	
	
	//méthode dans le cas ou l'accès est refusé
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String afficheDenied() {
		return "deniedPage";
	}
	
	//méthode appelé dans le cas ou l'authentification a échoué
	@RequestMapping(value="/echec", method=RequestMethod.GET)
	public String afficheEchec (ModelMap modele) {
		modele.addAttribute("erreur", true);
		
		return "loginPage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String afficheLogout (Model modele) {
		modele.addAttribute("msg", true);
		return "loginPage";
	}
}
