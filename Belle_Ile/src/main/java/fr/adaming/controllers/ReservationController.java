package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Reservation;
import fr.adaming.model.Vol;
import fr.adaming.service.ILocationVoitureService;
import fr.adaming.service.IMailService;
import fr.adaming.service.IOffreService;
import fr.adaming.service.IReservationService;

@Controller
@RequestMapping("/resa")
public class ReservationController {

	@Autowired
	private IOffreService offreService;

	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}

	@Autowired
	private IReservationService resaService;

	public void setResaService(IReservationService resaService) {
		this.resaService = resaService;
	}

	@Autowired
	private ILocationVoitureService locationService;

	public void setLocationService(ILocationVoitureService locationService) {
		this.locationService = locationService;
	}

	private Reservation resaValidation;
	
	@Autowired
	private IMailService mailService;
	
	public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}

	@PostConstruct
	public void init () {
		this.resaValidation=new Reservation();
	}

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

	@RequestMapping(value = "/showResaLink", method = RequestMethod.GET)
	public String showReservation(Model model, Client cl, @RequestParam("pId") int id,
			@RequestParam(value = "msg", required = false) String msg, RedirectAttributes rda) {

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		Offre offreIn = new Offre();
		offreIn.setId_offre(id);

		Offre offreOut = offreService.searchOffreById(offreIn);

		// Client a r�cup�rer dans la session
		cl.setId(1);

		Reservation resaCl = new Reservation();
		resaCl.setClient(cl);
		resaCl.setOffre(offreOut);

		model.addAttribute("resaCl", resaCl);
		model.addAttribute("offreOut", offreOut);

		// pour afficher la liste des locations possible
		List<LocationVoiture> listeLoc = locationService.searchAllLC();
		model.addAttribute("listeLoc", listeLoc);

		return "clientResa";
	}

	@RequestMapping(value = "/client/addResa", method = RequestMethod.POST)
	public String passerResa(Model model, @ModelAttribute("resaCl") Reservation resaCl, RedirectAttributes rda) {

		// Client � r�cup�rer dans la session
		Client cl = new Client();
		cl.setId(1);

		// pour r�cup�rer l'offre de la r�servation
		Offre offre = new Offre();
		offre.setId_offre(resaCl.getOffre().getId_offre());

		int verif = resaService.verifNbrePlaceDispo(resaCl, offre);

		if (verif == 1) {

			if (resaCl.getLocation() != null) {
				System.out.println(resaCl.getLocation());
				this.resaValidation.setLocation(resaCl.getLocation());
				this.resaValidation.setOffre(offre);
			}
			this.resaValidation.setNbrePlace(resaCl.getNbrePlace());

			mailService.email(cl, "Reservation belle ile", "Vous avez valider votre r�servation", "Facture Belle ile", " voici votre facture : "+ this.resaValidation.getPrixTotal()+" euros");

			return "redirect:showValResa";
		} else {
			return "clientResaInvalide";
		}
	}

	@RequestMapping(value = "/client/showValResa", method = RequestMethod.GET)
	public String afficheValResa(Model model) {

		// Client � r�cup�rer dans la session
		Client cl = new Client();
		cl.setId(1);

		
		System.out.println(this.resaValidation);
		
		
		Offre offreIn = offreService.searchOffreById(this.resaValidation.getOffre());
		
		System.out.println(offreIn);
	
		this.resaValidation.setPrixTotal(offreIn.getPrix() * this.resaValidation.getNbrePlace());

		
		this.resaValidation.setLocation(locationService.searchById(this.resaValidation.getLocation()));
		
				
		if (this.resaValidation.getLocation() != null) {
			this.resaValidation.setPrixTotal(this.resaValidation.getPrixTotal()
					+ (offreIn.getNbNuit() * this.resaValidation.getLocation().getPrixJournee()));
		}

		model.addAttribute("resaCl", this.resaValidation);
		return "clientValResa";
	}

	@RequestMapping(value = "/client/valResa", method = RequestMethod.GET)
	public String valResa(Model model) {

		// Client � r�cup�rer dans la session
		Client cl = new Client();
		cl.setId(1);

		Offre offreIn = new Offre();
		offreIn.setId_offre(this.resaValidation.getOffre().getId_offre());

		Reservation resaOut = resaService.addResa(this.resaValidation, cl, offreIn);

		if (resaOut != null) {
			return "clientResaValide";
		} else {
			return "erreur";
		}

	}
	
	@RequestMapping("/client/annuleResa")
	public String annuleResa () {
		
		this.resaValidation=null;
		
		return "redirect:../listeOffreEnCours";
		
	}
}
