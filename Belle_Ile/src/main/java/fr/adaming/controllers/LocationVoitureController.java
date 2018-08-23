package fr.adaming.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.LocationVoiture;
import fr.adaming.service.ILocationVoitureService;

@Controller
@RequestMapping("/admin/location")
public class LocationVoitureController {

	/*
	 * association uml en java
	 */
	@Autowired
	private ILocationVoitureService lcService;

	/*
	 * setter pour injection dépendance
	 */

	public void setLcService(ILocationVoitureService lcService) {
		this.lcService = lcService;
	}

	/*
	 * Afficher la liste des location de voiture possible
	 */
	@RequestMapping(value = "/listLC", method = RequestMethod.GET)
	public ModelAndView afficheListeLC() {

		List<LocationVoiture> listeLC = lcService.searchAllLC();

		return new ModelAndView("affLC", "listeLC", listeLC);

	}

	/*
	 * Ajouter une location de voiture
	 */

	@RequestMapping(value = "/showAddLC", method = RequestMethod.GET)
	public String afficheAddLC(Model modele) {

		modele.addAttribute("lcAjout", new LocationVoiture());

		return "ajoutLC";

	}

	@RequestMapping(value = "/addLC", method = RequestMethod.POST)
	public String ajoutLCForm(@ModelAttribute("lcAjout") LocationVoiture lc, RedirectAttributes rda) {

		LocationVoiture lcOut = lcService.add(lc);

		if (lcOut.getId_location() != 0) {

			return "redirect:listLC";
		} else {
			rda.addAttribute("msg", "l'ajout a échoué");
			return "redirect:addLC";
		}

	}

}
