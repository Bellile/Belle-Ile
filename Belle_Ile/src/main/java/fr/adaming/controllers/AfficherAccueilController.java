package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hotel;
import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IOffreService;
import fr.adaming.service.IVolService;

@Controller
@RequestMapping("/accueil")
public class AfficherAccueilController {
	
	@Autowired
	private IHotelService hService;

	public void sethService(IHotelService hService) {
		this.hService = hService;
	}
	
	@Autowired
	private IOffreService offreService;

	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}
	
	@Autowired
	private IVolService volService;

	
	@RequestMapping(value = "/listeOffreEnCours", method = RequestMethod.GET)
	public ModelAndView afficheListeOffreEnCours() {
		Date date = new Date();
		Vol vol = new Vol();
		vol.setdDepart(date);

		List<Offre> listeOffre = offreService.searchAllOffre();
		List<Offre> listeOffreEnCours = new ArrayList<Offre>();

		for (Offre o : listeOffre) {
			if (o.getVol().getdDepart().after(date) && o.getNbDispo() > 0) {
				listeOffreEnCours.add(o);
			}
		}
		return new ModelAndView("offreEnCours", "listeOffreEnCours", listeOffreEnCours);
	}
	
	
	@RequestMapping(value = "/showAccueile", method = RequestMethod.GET)
	public ModelAndView affichAccueil() {
		// Récupération de la liste des catégories
		List<Hotel> list = hService.searchAllHotel();

		return new ModelAndView("accueil", "liste", list);
	}

	@RequestMapping(value = "/showAccueil", method = RequestMethod.GET)
	public String affichAccueil2 (Model model) {
		
		List<Hotel> listeHotel=hService.searchAllHotel();
		
		model.addAttribute("listeHotel", listeHotel);
		
		
		
		Date date=new Date();
		Vol vol=new Vol();
		vol.setdDepart(date);
		List<Offre> listeOffre = offreService.searchAllOffre();
		List<Offre> listeOffreEnCours = new ArrayList<Offre>();
		
		for (Offre o : listeOffre) {
			if (o.getVol().getdDepart().after(date) && o.getNbDispo() > 0) {
				listeOffreEnCours.add(o);
			}
		}

		model.addAttribute("listeOffre", listeOffreEnCours);
		
		return "accueil";
		
	}
	
	@RequestMapping(value = "/searchVolLink", method = RequestMethod.GET)
	public String rechercherOffre(Model model, @RequestParam("pId") int id, RedirectAttributes rda) {
		Vol volIn = new Vol();
		volIn.setId_vol(id);

		Vol volOut = volService.searchVolById(volIn);

		if (volOut != null) {

			model.addAttribute("volOut", volOut);
			return "volSearchById";
		} else {
			model.addAttribute("searchVol", true);
			return "";
		}

	}
}
