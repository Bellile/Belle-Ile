package fr.adaming.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Hotel;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/admin/hot")
public class HotelController {

	//Transforamtion de l'association UML en JAVA
	private IHotelService hService;

	//Les setter de l'injection dépendance
	public void sethService(IHotelService hService) {
		this.hService = hService;
	}
	
	//----Methode afficher liste hotel
	@RequestMapping(value="/listeHotel", method=RequestMethod.GET)
	public ModelAndView affListeHot() {
		//Récupération de la liste des catégories
		List<Hotel> list = hService.searchAllHotel();
		
		return new ModelAndView("adminHotelListe", "listeHotel", list);
	}
	
	
}
