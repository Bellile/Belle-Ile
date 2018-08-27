package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IHotelService;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping(value = "/admin/offre")
public class OffreController {

	// Attributs
	private FileUpload file;

	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IOffreService offreService;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param offreService
	 */
	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}

	@Autowired
	private IHotelService hotelService;
	
	
	public OffreController() {
		super();
	}

	@RequestMapping(value = "/listeOffre", method = RequestMethod.GET)
	public ModelAndView afficheListeOffre() {
		List<Offre> listeOffre = offreService.searchAllOffre();
		return new ModelAndView("adminOffreListe", "listeOffre", listeOffre);
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
		return new ModelAndView("adminOffreListe", "listeOffre", listeOffreEnCours);
	}

	// ----Methode pour ajouter une categorie
	@RequestMapping(value = "/showAddOffre", method = RequestMethod.GET)
	public String showAjoutOffre(Model model, @RequestParam(value = "msg", required = false) String msg,
			@RequestParam(value = "msg2", required = false) String msg2) {

		if (msg != null) {
			model.addAttribute("msg", msg);
		}
		if (msg2 != null) {
			model.addAttribute("msg2", msg2);
		}
		model.addAttribute("offreAjout", new Offre());
		
		List<Hotel> listeHotel=hotelService.searchAllHotel();
		model.addAttribute("listeHotel", listeHotel);

		return "adminOffreAjout";
	}

	@RequestMapping(value = "/addOffre", method = RequestMethod.POST)
	public String ajoutOffre(@ModelAttribute("offreAjout") Offre offre, Model model, MultipartFile file)
			throws IOException {

		if (file != null) {
			// Transforamtion de l'image en tableau de byte
			offre.setPhoto(file.getBytes());
		}

		try {
			Offre offreOut = offreService.addOffre(offre);

			if (offreOut.getId_offre() != 0) {
								
				model.addAttribute("idOffre", offreOut.getId_offre());
				
				return "redirect:/admin/vol/showAddVol";

			} else {

			
				return "redirect:showAddOffre";
			}

		} catch (Exception e) {

			
			return "redirect:showAddOffre";
		}

	}

	@RequestMapping(value = "deleteOffre", method = RequestMethod.GET)
	public String deleteOffre(@RequestParam("pId") int id, RedirectAttributes rda) {
		Offre offreIn = new Offre();
		offreIn.setId_offre(id);

		int verif = offreService.deleteOffre(offreIn);

		if (verif != 0) {
			return "redirect:listeOffre";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:listeOffre";
		}

	}

	@RequestMapping(value = "/showUpdateOffre", method = RequestMethod.GET)
	public String showUpdateOffre(Model model, @RequestParam(value = "msg", required = false) String msg) {

		if (msg != null) {
			model.addAttribute("msg", msg);
		}
		model.addAttribute("offreUpdate", new Offre());
		return "adminOffreUpdate";
	}

	@RequestMapping(value = "/updateOffre", method = RequestMethod.POST)
	public String updateOffre(@ModelAttribute("offreUpdate") Offre offreIn, RedirectAttributes rda) {

		Offre offreOut=offreService.searchOffreById(offreIn);
		
		if (offreIn.getHotel() != null) {
			//permet de garder l'hotel qui est déjà enregistré s'il n'y a pas de modif 
			offreIn.setHotel(offreOut.getHotel());
		}

		
		if (offreIn.getVol() != null) {
			//permet de garder le vol qui est déjà enregistré s'il n'y a pas de modif 
			offreIn.setVol(offreOut.getVol());
		}

		// appel de la méthode service pour ajouter l'étudiant
		int verif = offreService.updateOffre(offreIn);

		if (verif != 0) {
			return "redirect:listeOffre";

		} else {

			rda.addAttribute("msg", true);
			return "redirect:showUpdateOffre";
		}
	}

	@RequestMapping(value = "/updateOffreLink")
	public String updateLien(Model modele, @RequestParam("pId") int id, RedirectAttributes rda) {

		Offre offreIn = new Offre();
		offreIn.setId_offre(id);

		Offre offreOut = offreService.searchOffreById(offreIn);

		modele.addAttribute("offreUpdate", offreOut);
		return "adminOffreUpdate";
	}

	// ----Methode pour ajouter une categorie
	@RequestMapping(value = "/showSearchOffre", method = RequestMethod.GET)
	public String showRechercherOffre(Model model, @RequestParam(value = "msg", required = false) String msg) {
		// Specification du model

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		model.addAttribute("offreSearch", new Offre());

		return "adminOffreSearchById";
	}

	@RequestMapping(value = "/searchOffre", method = RequestMethod.POST)
	public String rechercherOffre(Model model, @ModelAttribute("offreSearch") Offre offreIn, RedirectAttributes rda,
			MultipartFile file) throws IOException {

		Offre offreOut = offreService.searchOffreById(offreIn);

		if (offreOut != null) {
			model.addAttribute("resultat", true);
			model.addAttribute("offreOut", offreOut);
			return "adminOffreSearchById";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:showSearchOffre";
		}

	}

	// Methode pour recuperer les images de hotel
	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getHotelImage(@RequestParam("pId") int id) throws IOException {
		Offre offreIn = new Offre();
		offreIn.setId_offre(id);
		Offre offreOut = offreService.searchOffreById(offreIn);

		if (offreOut.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(offreOut.getPhoto()));
		}

	}

}
