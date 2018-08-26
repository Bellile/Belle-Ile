package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.IRechercheService;

@Controller
@RequestMapping("/rech")
public class RechercheController {

	//Transformation de l'association UML en JAVA
	private IRechercheService rService;

	public void setrService(IRechercheService rService) {
		this.rService = rService;
	}
	
}
