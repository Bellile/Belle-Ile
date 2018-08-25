package fr.adaming.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IVolService;

@Controller
@RequestMapping("/admin/vol")
public class VolController {

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IVolService volService;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param volService
	 */
	public void setVolService(IVolService volService) {
		this.volService = volService;
	}

	public VolController() {
		super();
	}

	// initBinder, se met en route dès qu'il y a une date dans la requete
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// WebDataBinder sert a lier les paramètres de la requete aux objets
		// java
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

		formatDate.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	@RequestMapping(value = "/listeVol", method = RequestMethod.GET)
	public ModelAndView afficheListeVol() {
		// récupérer la liste des vol
		List<Vol> listeVol = volService.searchAllVol();

		return new ModelAndView("adminListeVol", "listeVol", listeVol);
	}

	@RequestMapping(value = "/showAddVol", method = RequestMethod.GET)
	public ModelAndView showAddVol() {
		return new ModelAndView("adminAjoutVol", "volAjout", new Vol());
	}

	@RequestMapping(value = "addVol", method = RequestMethod.POST)
	public String addVol(@ModelAttribute Vol volIn, RedirectAttributes rda) {

		Vol volOut = volService.addVol(volIn);

		if (volOut.getId_vol() != 0) {
			return "redirect:listeVol";
		} else {
			rda.addAttribute("msg", "La création du vol a échoué");
			return "redirect:showAddVol";
		}

	}

	@RequestMapping(value = "deleteVol", method = RequestMethod.GET)
	public String deleteVol(@RequestParam("pId") int id, RedirectAttributes rda) {
		Vol volIn = new Vol();
		volIn.setId_vol(id);

		int verif = volService.deleteVol(volIn);

		if (verif != 0) {
			return "redirect:listeVol";
		} else {
			rda.addAttribute("msg", "La suppression a échoué");
			return "redirect:listeVol";
		}

	}

	@RequestMapping(value = "/showUpdateVol", method = RequestMethod.GET)
	public String showUpdateVol(Model model, @RequestParam(value = "msg", required = false) String msg) {

		if (msg != null) {
			model.addAttribute("msg", msg);
		}
		model.addAttribute("volUpdate", new Vol());
		return "adminVolUpdate";
	}

	@RequestMapping(value = "/updateVol", method = RequestMethod.POST)
	public String updateVol(@ModelAttribute("volUpdate") Vol volIn, RedirectAttributes rda) {

		// appel de la méthode service pour ajouter l'étudiant
		int verif = volService.updateVol(volIn);

		if (verif != 0) {
			return "redirect:listeVol"; // ici appelle le RequestMapping
										// "/liste"
		} else {

			rda.addAttribute("msg", true);
			return "redirect:showUpdateVol";
		}
	}

	@RequestMapping(value = "/updateVolLink")
	public String updateLien(Model modele, @RequestParam("pId") int id, RedirectAttributes rda) {


		Vol volIn = new Vol();
		volIn.setId_vol(id);

		Vol volOut = volService.searchVolById(volIn);

		modele.addAttribute("volUpdate", volOut);
		return "adminVolUpdate";
	}
	
	


		@RequestMapping(value = "/searchVolLink", method = RequestMethod.GET)
		public String rechercherOffre(Model model, @RequestParam("pId") int id, RedirectAttributes rda) {
			Vol volIn=new Vol();
			volIn.setId_vol(id);
			
			Vol volOut = volService.searchVolById(volIn);

			System.out.println(volOut);
			if (volOut != null) {
				
				model.addAttribute("volOut", volOut);
				return "adminVolSearchById";
			} else {
				model.addAttribute("searchVol", true);
				return "";
			}

		}
	
	
}
