package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/admin/cat")
public class CategorieController {
	
	//Transforamtion de l'association UML en JAVA
	@Autowired
	private ICategorieService catService;

	//Les setter de l'injection d�pendance
	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}
	
	//----Methode pour afficher une lsite des cat�gories
	@RequestMapping(value="/listeCat", method=RequestMethod.GET)
	public ModelAndView affListeCat() {
		//R�cup�ration de la liste des cat�gories
		List<Categorie> list = catService.searchAllCat();
		
		return new ModelAndView("affCat", "listeCat", list);
	}
	
	//----Methode pour ajouter une categorie
	@RequestMapping(value="/showAddCat", method=RequestMethod.GET)
	public String showAjoutCat(Model model) {
		//Specification du model
		model.addAttribute("catAjout", new Categorie());
		
		return "ajoutCat";
	}
	@RequestMapping(value="/addCat", method=RequestMethod.POST)
	public String ajoutCat(@ModelAttribute("catAjout")Categorie cat, RedirectAttributes rda) {
		Categorie catOut = catService.addCat(cat);
		
		if (catOut.getId_cat()!=0) {
			return "redirect:listeCat";
		} else {
			rda.addAttribute("msg", "L'ajout de cat�gorie a �chou�.");
			return "redirect:showAddCat";
		}
	}
}
