package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.model.Offre;
import fr.adaming.service.IRechercheService;

@Controller
@RequestMapping("/rech")
public class RechercheController {

	List<Double[]> listeC;
	
	//Transformation de l'association UML en JAVA
	private IRechercheService rService;

	
	public void setrService(IRechercheService rService) {
		this.rService = rService;
	}
	
	@PostConstruct
	public void getCoor() {
	this.listeC = new ArrayList<Double[]>();
	
		for (int i=0; i<10; i++) {
			Double[] coor = { ((double)(Math.random()*(1000))-500), ((double)(Math.random()*(1000))-500)};
			this.listeC.add(coor);
		}
	}
	
	@RequestMapping("/map")
	public String affMap(Model model) {
		model.addAttribute("coor", listeC);
		return "map";
	}
	
	@RequestMapping("/offre")
	public String rechOffre (Model model, String rech) {
		List<Offre> listeOffre = rService.searchByStringOffre(rech);
		List<Offre> listeOffreEnCours = new ArrayList<Offre>();
		Date date=new Date();
		
		for (Offre o : listeOffre) {
			if (o.getVol().getdDepart().after(date) && o.getNbDispo() > 0) {
				listeOffreEnCours.add(o);
			}
		}

		model.addAttribute("listeOffre", listeOffreEnCours);
		return "affOffre";
	}
}
