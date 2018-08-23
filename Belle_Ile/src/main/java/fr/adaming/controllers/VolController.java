package fr.adaming.controllers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	
	
	
	
	
}
