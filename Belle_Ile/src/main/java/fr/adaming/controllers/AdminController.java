package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {

	@RequestMapping(value = "/admin/accueil", method = RequestMethod.GET)
	public String afficheListeOffre() {
		
		return "adminAccueil";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String afficheFormLogin() {

		return "adminLoginPage";
	}
	
	
	
	//m�thode dans le cas ou l'acc�s est refus�
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String afficheDenied() {
		return "adminDeniedPage";
	}
	
	//m�thode appel� dans le cas ou l'authentification a �chou�
	@RequestMapping(value="/echec", method=RequestMethod.GET)
	public String afficheEchec (ModelMap modele) {
		modele.addAttribute("erreur", true);
		
		return "adminLoginPage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String afficheLogout (Model modele) {
		modele.addAttribute("msg", true);
		return "adminLoginPage";
	}
}
