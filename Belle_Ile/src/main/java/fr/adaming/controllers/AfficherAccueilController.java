package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Offre;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping("/accueil")
public class AfficherAccueilController {

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IOffreService offreService;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param offreService
	 */
	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}

	@RequestMapping(value = "/showAccueil", method = RequestMethod.GET)
	private ModelAndView affichAccueil() {
		List<Offre> listeOffre = offreService.searchAllOffre();

		return new ModelAndView("accueil", "listeOffre", listeOffre);
	}

}
