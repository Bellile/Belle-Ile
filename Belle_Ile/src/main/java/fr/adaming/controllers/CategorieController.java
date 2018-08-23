package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return new ModelAndView("adminListeCat", "listeCat", list);
	}
	
	//----Methode pour ajouter une categorie
	@RequestMapping(value="/showAddCat", method=RequestMethod.GET)
	public String showAjoutCat(Model model) {
		//Specification du model
		model.addAttribute("catAjout", new Categorie());
		
		return "adminAjoutCat";
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
	
	//----Methode pour supprimer une categorie
	@RequestMapping(value="/delCatLink/{pId}")
	public ModelAndView suppCatLien(@PathVariable("pId")int id) {
		//instanciation d'un objet Categorie
		Categorie cat = new Categorie();
		cat.setId_cat(id);
		
		//Appel de la m�thode
		catService.deleteCat(cat);
		
		//R�cup�ration de la liste
		List<Categorie> list = catService.searchAllCat();
		
		return new ModelAndView("adminListeCat", "listeCat", list);
	}
	
	//----Methode pour modifier une categorie
	//Afficher le formulaire pour modifier une cat�gorie
	@RequestMapping(value="/showUpdCat", method=RequestMethod.GET)
	public ModelAndView showModifCat() {
		
		return new ModelAndView("adminModifCat", "modifCat", new Categorie());
	}
	
	//Modifier
	@RequestMapping(value="/updCat", method=RequestMethod.POST)
	public String modifCat(@ModelAttribute("modifCat")Categorie cat, RedirectAttributes rda) {
		int verif = catService.updateCat(cat);
		
		if (verif!=0) {
			return "redirect:listeCat";
		} else {
			rda.addAttribute("msg", "La modification a �chou�");
			return "redirect:showUpdCat";
		}
	}
	
	//Modifier par lien
	@RequestMapping(value="/updCatLink")
	public String modifCatLink(Model model, @RequestParam("pId")int id) {
		Categorie catIn = new Categorie();
		catIn.setId_cat(id);
		
		Categorie catUpd = catService.searchByIdCat(catIn);
		
		model.addAttribute("modifCat", catUpd);
		
		return "adminModifCat";
		
	}
}
