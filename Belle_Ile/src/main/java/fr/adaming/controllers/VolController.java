package fr.adaming.controllers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Vol;
import fr.adaming.service.IVolService;

@ControllerAdvice
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
	 * @param volDao
	 */
	public void setVolDao(IVolService volService) {
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
	
	
	@RequestMapping(value="/listeVol", method=RequestMethod.GET)
	public ModelAndView afficheListeVol() {
		//récupérer la liste des vol
		List<Vol> listeVol = volService.searchAllVol();
		
		return new ModelAndView("adminListeVol", "listeVol", listeVol);
	}
	
	@RequestMapping(value="/showAddVol", method=RequestMethod.GET)
	public ModelAndView showAddVol () {
		return new ModelAndView("adminAjoutVol", "volAjout", new Vol());
	}
	
	
	@RequestMapping(value="addVol", method=RequestMethod.POST)
	public String addVol (@ModelAttribute Vol volIn, RedirectAttributes rda) {
		
		Vol volOut=volService.addVol(volIn);
		
		if (volOut.getId_vol() !=0) {
			return "redirect:listeVol";
		}else {
			rda.addAttribute("msg", "La création du vol a échoué");
			return "redirect:showAddVol";
		}
		
	}
	
	@RequestMapping(value="deleteVol", method=RequestMethod.GET)
	public String deleteVol (@RequestParam("pId") int id, RedirectAttributes rda) {
		Vol volIn=new Vol();
		volIn.setId_vol(id);
		
		int verif = volService.deleteVol(volIn);
		
		if (verif !=0) {
			return "redirect:listeVol";
		}else {
			rda.addAttribute("msg", "La suppression a échoué");
			return "redirect:listeVol";
		}
		
	}
	
	
	
	
}
