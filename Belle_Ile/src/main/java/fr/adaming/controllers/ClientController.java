package fr.adaming.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	/*
	 * Association uml en java
	 */
	
	private IClientService cService;

	/*
	 * Setter
	 */
	
	public void setcService(IClientService cService) {
		this.cService = cService;
	}
	

	/*
	 * Afficher la liste des locations de voiture possible (inutile)
	 */
	
	@RequestMapping(value="/listeCL", method=RequestMethod.GET)
	public ModelAndView afficheListeClient(){
		
		List<Client> listeClient = cService.searchAllCl();
		
		return new ModelAndView("clientListeClient", "listeClient", listeClient);
		
	}
	
	
	/*
	 * Ajouter un client
	 */
	@RequestMapping(value="/showAddCient", method=RequestMethod.GET)	
	public String afficheAddClientForm(Model modele){
		
		modele.addAttribute("clAjout", new Client());
		
		return "clientAjoutClient";
		
	}
	
	@RequestMapping(value="/addCL", method=RequestMethod.POST)
	public String ajoutClientForm(@ModelAttribute("clAjout") Client cl, RedirectAttributes rda){
	
	Client clOut=cService.addCl(cl);
	
	if(clOut.getId()!=0){
		return"redirect:accueil";
	}else{
	rda.addAttribute("msg", "L'ajout n'a pas été effectué");
	
	}
	
	}

	
	
	
	
}
