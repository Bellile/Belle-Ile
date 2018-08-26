package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Hotel;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/accueil")
public class AfficherAccueilController {
	
	@Autowired
	private IHotelService hService;
	
	@RequestMapping(value="/showAccueil", method=RequestMethod.GET)
	private ModelAndView affichAccueil(){
		//Récupération de la liste des catégories
		List<Hotel> list = hService.searchAllHotel();
		
		return new ModelAndView("accueil", "liste", list);
	}
	
	
	
	

}
