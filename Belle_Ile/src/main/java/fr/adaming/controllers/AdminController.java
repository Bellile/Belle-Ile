package fr.adaming.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/listeOffre", method = RequestMethod.GET)
	public String afficheListeOffre() {
		
		return "adminAccueil";
	}
}
